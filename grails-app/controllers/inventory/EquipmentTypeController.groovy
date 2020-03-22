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
class EquipmentTypeController {

    EquipmentTypeService equipmentTypeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond equipmentTypeService.list(params), model:[equipmentTypeCount: equipmentTypeService.count()]
    }

    def show(Long id) {
        respond equipmentTypeService.get(id)
    }

    @Transactional
    def save(EquipmentType equipmentType) {
        if (equipmentType == null) {
            render status: NOT_FOUND
            return
        }
        if (equipmentType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond equipmentType.errors
            return
        }

        try {
            equipmentTypeService.save(equipmentType)
        } catch (ValidationException e) {
            respond equipmentType.errors
            return
        }

        respond equipmentType, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(EquipmentType equipmentType) {
        if (equipmentType == null) {
            render status: NOT_FOUND
            return
        }
        if (equipmentType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond equipmentType.errors
            return
        }

        try {
            equipmentTypeService.save(equipmentType)
        } catch (ValidationException e) {
            respond equipmentType.errors
            return
        }

        respond equipmentType, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        equipmentTypeService.delete(id)

        render status: NO_CONTENT
    }
}
