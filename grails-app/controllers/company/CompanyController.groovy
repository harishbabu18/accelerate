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
class CompanyController {

    CompanyService companyService
    AmazonS3Service amazonS3Service

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def count = companyService.count()
        def offset = params.offset as Long
        Long currentpage = Math.ceil((params.max+offset)/params.max)
        Long pagecount = Math.ceil(count/params.max)
        respond companyService.list(params), model:[companyCount: count,companyPage:currentpage,companyPageCount:pagecount]
    }

    def show(Long id) {
        respond companyService.get(id)
    }

    @Transactional
    def save(Company company) {


        def mydate = new Date(System.currentTimeMillis())

        if (company == null) {
            render status: NOT_FOUND
            return
        }
        if (company.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond company.errors
            return
        }

        try {
//            if(params.featuredImageFile!=null){
//            String path = "company/"+params.email+params.featuredImageFile.originalFilename
//            amazonS3Service.storeMultipartFile(path,params.featuredImageFile)
//            company.avatar =path
//            }
            companyService.save(company)
        } catch (ValidationException e) {
            respond company.errors
            return
        }

        respond company, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Company company) {
        if (company == null) {
            render status: NOT_FOUND
            return
        }
        if (company.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond company.errors
            return
        }

        try {
            companyService.save(company)
        } catch (ValidationException e) {
            respond company.errors
            return
        }

        respond company, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        companyService.delete(id)

        render status: NO_CONTENT
    }
}
