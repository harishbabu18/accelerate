package inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EquipmentTypeServiceSpec extends Specification {

    EquipmentTypeService equipmentTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EquipmentType(...).save(flush: true, failOnError: true)
        //new EquipmentType(...).save(flush: true, failOnError: true)
        //EquipmentType equipmentType = new EquipmentType(...).save(flush: true, failOnError: true)
        //new EquipmentType(...).save(flush: true, failOnError: true)
        //new EquipmentType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //equipmentType.id
    }

    void "test get"() {
        setupData()

        expect:
        equipmentTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EquipmentType> equipmentTypeList = equipmentTypeService.list(max: 2, offset: 2)

        then:
        equipmentTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        equipmentTypeService.count() == 5
    }

    void "test delete"() {
        Long equipmentTypeId = setupData()

        expect:
        equipmentTypeService.count() == 5

        when:
        equipmentTypeService.delete(equipmentTypeId)
        sessionFactory.currentSession.flush()

        then:
        equipmentTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EquipmentType equipmentType = new EquipmentType()
        equipmentTypeService.save(equipmentType)

        then:
        equipmentType.id != null
    }
}
