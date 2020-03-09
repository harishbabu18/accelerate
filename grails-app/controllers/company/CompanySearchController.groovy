package company


import grails.rest.*
import grails.converters.*

class CompanySearchController {
    static responseFormats = ['json', 'xml']

    def index() {
        def c = Company.createCriteria()
        def results = c.list {

            like("name", "%"+params.name+"%")

            and {
                if(params.startingfrom !=null){
                between("dateCreated", params.startingfrom,params.endingto)
                }
                if(params.startingfrom !=null) {
                    eq("country", params.country)
                }
                if(params.startingfrom !=null) {
                        eq("state", param.country)
                }
            }

        }
        respond results
    }
}

