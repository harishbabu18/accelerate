package accelerate

import company.OfficeType
import company.Position
import company.Supplierstatus
import inventory.QuantityType
import sales.OfferPayment
import sales.OfferType
import ticket.TicketSource
import ticket.TicketStatusType
import usermanagement.Organisation
import usermanagement.Role
import usermanagement.User
import usermanagement.UserRole

class BootStrap {

    def init = { servletContext ->

        Organisation teraret = new Organisation(name: "Teraret Managed Cloud Private Limited").save()
        Organisation qualifica = new Organisation(name: "Qualifica Group").save()

        User admin = new User(organisation: teraret,username: "babuamuda@gmail.com",password:"B@vana20").save()
        User qualificaadmin = new User(organisation: qualifica,username: "audit@qualificagroup.it",password:"test@123").save()

        User customer = new User(organisation: teraret,username: "liricsdash2014@gmail.com",password:"lirics@123").save()
        User account = new User(organisation: teraret,username: "akshitharajappa10@gmail.com",password:"akshitha@123").save()
        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role companyrole =new Role(authority: "ROLE_COMPANY").save()
        Role contactrole =new Role(authority: "ROLE_CONTACT").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()

        UserRole.create(admin,adminrole)
        UserRole.create(qualificaadmin,companyrole)
        UserRole.create(customer,customerrole)
        UserRole.create(account,accountrole)
        new Position(name: "Employee").save()
        new Position(name: "Freelancer").save()
        new OfficeType(name:"REGISTERED OFFICE").save()
        new OfficeType(name: "WARE HOUSE").save()
        new OfficeType(name: "HEAD QUATERS").save()
        new OfficeType(name: "OTHERS").save()
        new Supplierstatus(name: "Qualified",user: qualificaadmin).save()
        new Supplierstatus(name: "Unqualified",user: qualificaadmin).save()
        new Supplierstatus(name: "Reserved",user: qualificaadmin).save()

        new QuantityType(name: 'KG').save()
        new QuantityType(name: 'PZ').save()
        new QuantityType(name: 'LT').save()
        new QuantityType(name: 'GR').save()
        new QuantityType(name: 'MT').save()
        new QuantityType(name: 'CC').save()
        new QuantityType(name: 'HR').save()
        new QuantityType(name: 'CM').save()


        new TicketStatusType(name: "New").save()
        new TicketStatusType(name: "Open").save()
        new TicketStatusType(name: "Pending customer").save()
        new TicketStatusType(name: "Awaiting Third").save()
        new TicketStatusType(name: "Closed").save()
        new TicketStatusType(name: "0 ‐ Potential").save()
        new TicketStatusType(name: "01 ‐ Contact Established").save()
        new TicketStatusType(name: "01 ‐ Int. But Wait EXP").save()
        new TicketStatusType(name: "1 ‐ Hold Ns Activities").save()
        new TicketStatusType(name: "1 ‐ certifies Third Activity").save()
        new TicketStatusType(name: "1 ‐ Customer Waiting").save()
        new TicketStatusType(name: "1 * ‐ Negotiation Hot").save()
        new TicketStatusType(name: "Potential").save()
        new TicketStatusType(name: "Interested").save()
        new TicketStatusType(name: "won").save()
        new TicketStatusType(name: "Persa").save()
        new TicketStatusType(name: "Abandoned").save()

        new TicketSource(name: "Phone Call").save()
        new TicketSource(name: "App").save()
        new TicketSource(name: "Mail").save()

        new OfferType(name:'One Time').save()
        new OfferType(name:'semester').save()
        new OfferType(name:'Trimester').save()
        new OfferType(name:'Quarterly').save()
        new OfferType(name:'Half Yearly').save()
        new OfferType(name:'Annual').save()
        new OfferType(name:'Bi-Annual').save()

        new OfferPayment(name:'CREDIT CARD').save()
        new OfferPayment(name:'DEBIT CARD').save()
        new OfferPayment(name:'CHEQUE').save()
        new OfferPayment(name:'CASH').save()

    }
    def destroy = {
    }
}
