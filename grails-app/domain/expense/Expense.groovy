package expense

import usermanagement.User

class Expense {

    String name
    ExpenseType expenseType
    Double amount
    String note
    Date expensedate
    User spendBy
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
