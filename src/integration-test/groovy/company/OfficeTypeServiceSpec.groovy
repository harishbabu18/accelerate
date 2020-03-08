package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OfficeTypeServiceSpec extends Specification {

    OfficeTypeService officeTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OfficeType(...).save(flush: true, failOnError: true)
        //new OfficeType(...).save(flush: true, failOnError: true)
        //OfficeType officeType = new OfficeType(...).save(flush: true, failOnError: true)
        //new OfficeType(...).save(flush: true, failOnError: true)
        //new OfficeType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //officeType.id
    }

    void "test get"() {
        setupData()

        expect:
        officeTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OfficeType> officeTypeList = officeTypeService.list(max: 2, offset: 2)

        then:
        officeTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        officeTypeService.count() == 5
    }

    void "test delete"() {
        Long officeTypeId = setupData()

        expect:
        officeTypeService.count() == 5

        when:
        officeTypeService.delete(officeTypeId)
        sessionFactory.currentSession.flush()

        then:
        officeTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OfficeType officeType = new OfficeType()
        officeTypeService.save(officeType)

        then:
        officeType.id != null
    }
}
