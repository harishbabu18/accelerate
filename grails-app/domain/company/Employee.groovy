package company

import grails.gorm.MultiTenant
import usermanagement.User

class Employee  implements MultiTenant<Employee> {
    String organisation
    String avatar
    String firstName
    String lastName
    String email
    String mobile
    Date dob
    User user
    Date joiningdate
    Date relievingdate
    Date dateCreated
    Date lastUpdated

    static constraints = {
        avatar nullable:true, blank:true
        firstName matches: "[a-zA-Z ]+"
        lastName matches: "[a-zA-Z ]+"
        email unique:true,email: true
        relievingdate nullable:true, blank:true
}

    static mapping = {
        tenantId name: 'organisation'
    }
}
