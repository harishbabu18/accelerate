package company

class PaymentMethod {
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
