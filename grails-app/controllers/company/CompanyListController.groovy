package company


import grails.rest.*
import grails.converters.*

class CompanyListController {
    static responseFormats = ['json', 'xml']

    def index() {
        respond Company.list()
    }
}
