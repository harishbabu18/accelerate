package company

import usermanagement.User

class Employee {


    String avatar
    String firstName
    String lastName
    String email
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
}
