package company

import usermanagement.User

class Company {
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
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
        avatar nullable:true, blank:true
        name unique:true
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        fax nullable: true, blank: true
        addresslinetwo nullable: true, blank: true
        email unique:true,email: true
        website unique:true,nullable: true, blank: true

    }
}
