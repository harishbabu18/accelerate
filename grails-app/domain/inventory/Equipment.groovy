package inventory

import usermanagement.User

class Equipment {

    String name
    String description
    Integer serialNumber
    EquipmentType equipmentType
    Integer threshold
    String supplier
    Double salesprice
    Double purchaseprice
    Date deadline
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
