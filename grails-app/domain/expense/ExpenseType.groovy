package expense

class ExpenseType {
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
