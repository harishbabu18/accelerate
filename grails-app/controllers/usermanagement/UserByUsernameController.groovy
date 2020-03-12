package usermanagement


import grails.rest.*
import grails.converters.*

class UserByUsernameController {
	static responseFormats = ['json', 'xml']

    def index() {
        respond User.findByUsername(params.username)
    }

}
