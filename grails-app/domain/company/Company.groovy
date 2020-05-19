package company

import usermanagement.User

class Company {
    def springSecurityService

    String avatar
    String name
    String description
    Date establishedDate
    String email
    String mobile
    String website
    String fax
    OfficeType officeType
    String addresslineone
    String addresslinetwo
    String country
    String state
    String city
    String zip
    Date dateCreated
    Date lastUpdated
    User createdBy
    User lastUpdatedBy

    def beforeInsert() {

        createdBy = springSecurityService.getCurrentUser()
        lastUpdatedBy = springSecurityService.getCurrentUser()

    }

    def beforeUpdate() {

        lastUpdatedBy = springSecurityService.getCurrentUser()

    }



    static constraints = {

        avatar nullable:true, blank:true
        name unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        fax nullable: true, blank: true
        addresslinetwo nullable: true, blank: true
        email unique:true,email: true
        website unique:true,nullable: true, blank: true

        createdBy nullable: true, blank: true
        lastUpdatedBy nullable: true, blank: true

    }


}
