package accelerate

import company.OfficeType
import company.Position
import company.Supplierstatus
import usermanagement.Role
import usermanagement.User
import usermanagement.UserRole

class BootStrap {

    def init = { servletContext ->

        User admin = new User(username: "babuamuda@gmail.com",password:"B@vana20").save()
        User qualificaadmin = new User(username: "audit@qualificagroup.it",password:"test@123").save()

        User customer = new User(username: "liricsdash2014@gmail.com",password:"lirics@123").save()
        User account = new User(username: "akshitharajappa10@gmail.com",password:"akshitha@123").save()
        Role adminrole = new Role(authority: "ROLE_ADMIN").save()
        Role customerrole = new Role(authority: "ROLE_CUSTOMER").save()
        Role accountrole = new Role(authority: "ROLE_ACCOUNT").save()

        UserRole.create(admin,adminrole)
        UserRole.create(qualificaadmin,adminrole)

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



    }
    def destroy = {
    }
}
