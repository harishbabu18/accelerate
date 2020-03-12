package company

import usermanagement.User

class Supplier {
    String avatar
    String name
    String vat
    String pec
    String note
    String email
    String mobile
    String website
    String fax
    String services
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    Supplierstatus supplierstatus
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {

        avatar nullable:true, blank:true
        name unique:true
        fax nullable: true, blank: true
        vat nullable: true, blank: true
        pec nullable: true, blank: true
        note nullable: true, blank: true
        addresslinetwo nullable: true, blank: true
        email unique:true,email: true
        website unique:true,nullable: true, blank: true
    }
}
