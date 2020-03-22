package expense

import usermanagement.User

class Rent {

    String name
    Double amount
    String note
    Date expensedate
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
