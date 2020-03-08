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
class PaymentMethodController {

    PaymentMethodService paymentMethodService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paymentMethodService.list(params), model:[paymentMethodCount: paymentMethodService.count()]
    }

    def show(Long id) {
        respond paymentMethodService.get(id)
    }

    @Transactional
    def save(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            render status: NOT_FOUND
            return
        }
        if (paymentMethod.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond paymentMethod.errors
            return
        }

        try {
            paymentMethodService.save(paymentMethod)
        } catch (ValidationException e) {
            respond paymentMethod.errors
            return
        }

        respond paymentMethod, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            render status: NOT_FOUND
            return
        }
        if (paymentMethod.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond paymentMethod.errors
            return
        }

        try {
            paymentMethodService.save(paymentMethod)
        } catch (ValidationException e) {
            respond paymentMethod.errors
            return
        }

        respond paymentMethod, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        paymentMethodService.delete(id)

        render status: NO_CONTENT
    }
}
