package ticket

class TicketStatusType {
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
