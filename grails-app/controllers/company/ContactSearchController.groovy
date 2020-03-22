package company


import grails.rest.*
import grails.converters.*

class ContactSearchController {
	static responseFormats = ['json', 'xml']
	
    def index() {

        def c = Contact.createCriteria()
        def results = c.list {

            if(params.searchColumn == 'firstName'){
                like("firstName", "%" + params.search + "%")
            } else if(params.searchColumn  == 'lastName'){
                like("lastName", "%" + params.search + "%")
            } else if(params.searchColumn  == 'email'){
                like("email", "%" + params.search + "%")
            } else {
                like("mobile", "%" + params.search + "%")
            }

        }
        respond results
    }

}
