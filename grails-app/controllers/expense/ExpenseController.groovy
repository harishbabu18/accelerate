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
class ExpenseController {

    ExpenseService expenseService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond expenseService.list(params), model:[expenseCount: expenseService.count()]
    }

    def show(Long id) {
        respond expenseService.get(id)
    }

    @Transactional
    def save(Expense expense) {
        if (expense == null) {
            render status: NOT_FOUND
            return
        }
        if (expense.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond expense.errors
            return
        }

        try {
            expenseService.save(expense)
        } catch (ValidationException e) {
            respond expense.errors
            return
        }

        respond expense, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Expense expense) {
        if (expense == null) {
            render status: NOT_FOUND
            return
        }
        if (expense.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond expense.errors
            return
        }

        try {
            expenseService.save(expense)
        } catch (ValidationException e) {
            respond expense.errors
            return
        }

        respond expense, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        expenseService.delete(id)

        render status: NO_CONTENT
    }
}
