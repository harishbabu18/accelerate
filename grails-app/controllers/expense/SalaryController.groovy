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
class SalaryController {

    SalaryService salaryService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond salaryService.list(params), model:[salaryCount: salaryService.count()]
    }

    def show(Long id) {
        respond salaryService.get(id)
    }

    @Transactional
    def save(Salary salary) {
        if (salary == null) {
            render status: NOT_FOUND
            return
        }
        if (salary.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond salary.errors
            return
        }

        try {
            salaryService.save(salary)
        } catch (ValidationException e) {
            respond salary.errors
            return
        }

        respond salary, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Salary salary) {
        if (salary == null) {
            render status: NOT_FOUND
            return
        }
        if (salary.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond salary.errors
            return
        }

        try {
            salaryService.save(salary)
        } catch (ValidationException e) {
            respond salary.errors
            return
        }

        respond salary, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        salaryService.delete(id)

        render status: NO_CONTENT
    }
}
