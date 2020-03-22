package sales

import company.Address
import company.Services
import usermanagement.User

class OfferServices {
    Offer offer
    Services services
    Address address
    Integer interventions
    Double price
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
