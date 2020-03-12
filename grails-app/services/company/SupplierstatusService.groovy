package company

import grails.gorm.services.Service

@Service(Supplierstatus)
interface SupplierstatusService {

    Supplierstatus get(Serializable id)

    List<Supplierstatus> list(Map args)

    Long count()

    void delete(Serializable id)

    Supplierstatus save(Supplierstatus supplierstatus)

}