package company

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class SupplierstatusController {

    SupplierstatusService supplierstatusService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond supplierstatusService.list(params), model:[supplierstatusCount: supplierstatusService.count()]
    }

    def show(Long id) {
        respond supplierstatusService.get(id)
    }

    @Transactional
    def save(Supplierstatus supplierstatus) {
        if (supplierstatus == null) {
            render status: NOT_FOUND
            return
        }
        if (supplierstatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond supplierstatus.errors
            return
        }

        try {
            supplierstatusService.save(supplierstatus)
        } catch (ValidationException e) {
            respond supplierstatus.errors
            return
        }

        respond supplierstatus, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Supplierstatus supplierstatus) {
        if (supplierstatus == null) {
            render status: NOT_FOUND
            return
        }
        if (supplierstatus.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond supplierstatus.errors
            return
        }

        try {
            supplierstatusService.save(supplierstatus)
        } catch (ValidationException e) {
            respond supplierstatus.errors
            return
        }

        respond supplierstatus, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        supplierstatusService.delete(id)

        render status: NO_CONTENT
    }
}
