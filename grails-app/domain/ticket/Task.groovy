package ticket

import usermanagement.User

class Task {

    Ticket ticket
    User assignedTo
    User assignedBy
    String personalNote
    String publicMessage
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
