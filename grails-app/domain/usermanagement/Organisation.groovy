package usermanagement

class Organisation {

    String name

    static constraints = {
        name unique:true
    }
}
