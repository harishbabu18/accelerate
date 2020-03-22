package expense

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class ExpenseTypeController {

    ExpenseTypeService expenseTypeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond expenseTypeService.list(params), model:[expenseTypeCount: expenseTypeService.count()]
    }

    def show(Long id) {
        respond expenseTypeService.get(id)
    }

    @Transactional
    def save(ExpenseType expenseType) {
        if (expenseType == null) {
            render status: NOT_FOUND
            return
        }
        if (expenseType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond expenseType.errors
            return
        }

        try {
            expenseTypeService.save(expenseType)
        } catch (ValidationException e) {
            respond expenseType.errors
            return
        }

        respond expenseType, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ExpenseType expenseType) {
        if (expenseType == null) {
            render status: NOT_FOUND
            return
        }
        if (expenseType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond expenseType.errors
            return
        }

        try {
            expenseTypeService.save(expenseType)
        } catch (ValidationException e) {
            respond expenseType.errors
            return
        }

        respond expenseType, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        expenseTypeService.delete(id)

        render status: NO_CONTENT
    }
}
