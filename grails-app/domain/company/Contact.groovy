package company

import grails.gorm.MultiTenant
import usermanagement.User

class Contact implements MultiTenant<Contact> {
    String organisation
    String avatar
    Company company
    String firstName
    String lastName
    Date dob
    Position position
    String note
    String mobile
    String email
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
        avatar nullable:true, blank:true
        firstName matches: "[a-zA-Z ]+"
        lastName matches: "[a-zA-Z ]+"
        note nullable:true,blank:true
        addresslinetwo nullable: true, blank: true
        email unique:true,email: true
    }

    static mapping = {
        tenantId name: 'organisation'
    }
}
