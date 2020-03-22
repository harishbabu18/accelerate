package sales

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class OfferController {

    OfferService offerService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond offerService.list(params), model:[offerCount: offerService.count()]
    }

    def show(Long id) {
        respond offerService.get(id)
    }

    @Transactional
    def save(Offer offer) {
        if (offer == null) {
            render status: NOT_FOUND
            return
        }
        if (offer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond offer.errors
            return
        }

        try {
            offerService.save(offer)
        } catch (ValidationException e) {
            respond offer.errors
            return
        }

        respond offer, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Offer offer) {
        if (offer == null) {
            render status: NOT_FOUND
            return
        }
        if (offer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond offer.errors
            return
        }

        try {
            offerService.save(offer)
        } catch (ValidationException e) {
            respond offer.errors
            return
        }

        respond offer, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        offerService.delete(id)

        render status: NO_CONTENT
    }
}
