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
class EquipmentController {

    EquipmentService equipmentService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond equipmentService.list(params), model:[equipmentCount: equipmentService.count()]
    }

    def show(Long id) {
        respond equipmentService.get(id)
    }

    @Transactional
    def save(Equipment equipment) {
        if (equipment == null) {
            render status: NOT_FOUND
            return
        }
        if (equipment.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond equipment.errors
            return
        }

        try {
            equipmentService.save(equipment)
        } catch (ValidationException e) {
            respond equipment.errors
            return
        }

        respond equipment, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Equipment equipment) {
        if (equipment == null) {
            render status: NOT_FOUND
            return
        }
        if (equipment.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond equipment.errors
            return
        }

        try {
            equipmentService.save(equipment)
        } catch (ValidationException e) {
            respond equipment.errors
            return
        }

        respond equipment, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        equipmentService.delete(id)

        render status: NO_CONTENT
    }
}
