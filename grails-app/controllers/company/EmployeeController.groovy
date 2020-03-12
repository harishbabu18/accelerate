package company

import grails.plugin.awssdk.s3.AmazonS3Service
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class EmployeeController {

    EmployeeService employeeService
    AmazonS3Service amazonS3Service


    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond employeeService.list(params), model:[employeeCount: employeeService.count()]
    }

    def show(Long id) {
        respond employeeService.get(id)
    }

    @Transactional
    def save(Employee employee) {
        if (employee == null) {
            render status: NOT_FOUND
            return
        }
        if (employee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond employee.errors
            return
        }

        try {

            if(params.featuredImageFile!=null) {
                String path = "employee/" + params.email + params.featuredImageFile.originalFilename
                amazonS3Service.storeMultipartFile(path, params.featuredImageFile)
                employee.avatar = path
            }

            employeeService.save(employee)
        } catch (ValidationException e) {
            respond employee.errors
            return
        }

        respond employee, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Employee employee) {
        if (employee == null) {
            render status: NOT_FOUND
            return
        }
        if (employee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond employee.errors
            return
        }

        try {

            if(params.featuredImageFile!=null) {
                String path = "employee/" + params.email + params.featuredImageFile.originalFilename
                amazonS3Service.storeMultipartFile(path, params.featuredImageFile)
                employee.avatar = path
            }

            employeeService.save(employee)
        } catch (ValidationException e) {
            respond employee.errors
            return
        }

        respond employee, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        employeeService.delete(id)

        render status: NO_CONTENT
    }
}
