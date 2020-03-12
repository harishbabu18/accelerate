package company

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SupplierstatusServiceSpec extends Specification {

    SupplierstatusService supplierstatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Supplierstatus(...).save(flush: true, failOnError: true)
        //new Supplierstatus(...).save(flush: true, failOnError: true)
        //Supplierstatus supplierstatus = new Supplierstatus(...).save(flush: true, failOnError: true)
        //new Supplierstatus(...).save(flush: true, failOnError: true)
        //new Supplierstatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //supplierstatus.id
    }

    void "test get"() {
        setupData()

        expect:
        supplierstatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Supplierstatus> supplierstatusList = supplierstatusService.list(max: 2, offset: 2)

        then:
        supplierstatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        supplierstatusService.count() == 5
    }

    void "test delete"() {
        Long supplierstatusId = setupData()

        expect:
        supplierstatusService.count() == 5

        when:
        supplierstatusService.delete(supplierstatusId)
        sessionFactory.currentSession.flush()

        then:
        supplierstatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Supplierstatus supplierstatus = new Supplierstatus()
        supplierstatusService.save(supplierstatus)

        then:
        supplierstatus.id != null
    }
}
