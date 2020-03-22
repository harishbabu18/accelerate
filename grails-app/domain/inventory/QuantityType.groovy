package inventory

class QuantityType {
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
