package inventory

import grails.gorm.services.Service

@Service(Mean)
interface MeanService {

    Mean get(Serializable id)

    List<Mean> list(Map args)

    Long count()

    void delete(Serializable id)

    Mean save(Mean mean)

}