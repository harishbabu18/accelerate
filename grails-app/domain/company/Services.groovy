package company

import usermanagement.User

class Services {
    String name
    String description
    Double price
    Date deadline
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
        description nullable: true, blank: true
        deadline nullable: true, blank: true
    }
}
