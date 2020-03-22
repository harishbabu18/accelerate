package inventory

import usermanagement.User


class Product {
    ProductName name
    String barcode
    QuantityType quantityType
    Integer number
    Double quantity
    Double price
    User createBy
    Lot lot
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
