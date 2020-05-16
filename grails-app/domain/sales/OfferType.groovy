package sales

class OfferType {

    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
