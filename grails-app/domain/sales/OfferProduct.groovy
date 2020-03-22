package sales


import inventory.Product
import usermanagement.User

class OfferProduct {
    Offer offer
    Product product
    Double quantity
    Double price
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
