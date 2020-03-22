package company


import grails.rest.*
import grails.converters.*

class SupplierSearchController {
	static responseFormats = ['json', 'xml']


    def index() {

        def c = Supplier.createCriteria()
        def results = c.list {

            if(params.searchColumn == 'name'){
                like("name", "%" + params.search + "%")
            } else if(params.searchColumn  == 'email'){
                like("email", "%" + params.search + "%")
            } else {
                like("mobile", "%" + params.search + "%")
            }

        }
        respond results
    }
}
