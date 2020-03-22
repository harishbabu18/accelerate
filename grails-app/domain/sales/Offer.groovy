package sales

import company.Company
import company.Contact
import usermanagement.User

class Offer {
    Company company
    Contact contact
    String note
    Date startDate
    Date endDate
    String protocol
    Double approximatedealamount
    Double dealamount
    OfferPayment paymentmethod
    Double discount
    Double iva
    Double total
    User user
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
