package expense

import company.Employee
import usermanagement.User

class Salary {

    String name
    Double amount
    String note
    Date expensedate
    Employee employee
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
