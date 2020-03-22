package expense

import grails.gorm.services.Service

@Service(Rent)
interface RentService {

    Rent get(Serializable id)

    List<Rent> list(Map args)

    Long count()

    void delete(Serializable id)

    Rent save(Rent rent)

}