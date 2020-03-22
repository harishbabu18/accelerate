package sales

import inventory.Equipment
import usermanagement.User

class OfferEquipment {
    Offer offer
    Equipment equipment
    String typology
    Integer quantity
    Double price
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
