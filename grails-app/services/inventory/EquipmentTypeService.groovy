package inventory

import grails.gorm.services.Service

@Service(EquipmentType)
interface EquipmentTypeService {

    EquipmentType get(Serializable id)

    List<EquipmentType> list(Map args)

    Long count()

    void delete(Serializable id)

    EquipmentType save(EquipmentType equipmentType)

}