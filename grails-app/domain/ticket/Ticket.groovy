package ticket

import company.Company
import company.Contact
import usermanagement.User

class Ticket {
    String description
    boolean urgent
    boolean important
    TicketSource ticketSource
    TicketStatusType ticketStatus
    User createdBy
    User assignedTo
    Company company
    Contact contact
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
