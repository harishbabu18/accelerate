package ticket

class TicketSource {
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name unique:true
    }
}
