package inventory

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class MeanController {

    MeanService meanService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond meanService.list(params), model:[meanCount: meanService.count()]
    }

    def show(Long id) {
        respond meanService.get(id)
    }

    @Transactional
    def save(Mean mean) {
        if (mean == null) {
            render status: NOT_FOUND
            return
        }
        if (mean.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mean.errors
            return
        }

        try {
            meanService.save(mean)
        } catch (ValidationException e) {
            respond mean.errors
            return
        }

        respond mean, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Mean mean) {
        if (mean == null) {
            render status: NOT_FOUND
            return
        }
        if (mean.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mean.errors
            return
        }

        try {
            meanService.save(mean)
        } catch (ValidationException e) {
            respond mean.errors
            return
        }

        respond mean, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        meanService.delete(id)

        render status: NO_CONTENT
    }
}
