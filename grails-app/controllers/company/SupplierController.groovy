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
class SupplierController {

    SupplierService supplierService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond supplierService.list(params), model:[supplierCount: supplierService.count()]
    }

    def show(Long id) {
        respond supplierService.get(id)
    }

    @Transactional
    def save(Supplier supplier) {
        if (supplier == null) {
            render status: NOT_FOUND
            return
        }
        if (supplier.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond supplier.errors
            return
        }

        try {
            supplierService.save(supplier)
        } catch (ValidationException e) {
            respond supplier.errors
            return
        }

        respond supplier, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Supplier supplier) {
        if (supplier == null) {
            render status: NOT_FOUND
            return
        }
        if (supplier.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond supplier.errors
            return
        }

        try {
            supplierService.save(supplier)
        } catch (ValidationException e) {
            respond supplier.errors
            return
        }

        respond supplier, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        supplierService.delete(id)

        render status: NO_CONTENT
    }
}
