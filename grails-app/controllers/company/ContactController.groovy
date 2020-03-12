package company

import grails.plugin.awssdk.s3.AmazonS3Service
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class ContactController {

    ContactService contactService
    AmazonS3Service amazonS3Service


    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond contactService.list(params), model:[contactCount: contactService.count()]
    }

    def show(Long id) {
        respond contactService.get(id)
    }

    @Transactional
    def save(Contact contact) {
        if (contact == null) {
            render status: NOT_FOUND
            return
        }
        if (contact.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contact.errors
            return
        }

        try {
            if(params.featuredImageFile!=null) {
                String path = "contact/" + params.email + params.featuredImageFile.originalFilename
                amazonS3Service.storeMultipartFile(path, params.featuredImageFile)
                contact.avatar = path
            }
            contactService.save(contact)
        } catch (ValidationException e) {
            respond contact.errors
            return
        }

        respond contact, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Contact contact) {
        if (contact == null) {
            render status: NOT_FOUND
            return
        }
        if (contact.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contact.errors
            return
        }

        try {
            contactService.save(contact)
        } catch (ValidationException e) {
            respond contact.errors
            return
        }

        respond contact, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        contactService.delete(id)

        render status: NO_CONTENT
    }
}
