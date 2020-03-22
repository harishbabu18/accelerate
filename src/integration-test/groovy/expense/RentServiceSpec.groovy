package expense

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RentServiceSpec extends Specification {

    RentService rentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rent(...).save(flush: true, failOnError: true)
        //new Rent(...).save(flush: true, failOnError: true)
        //Rent rent = new Rent(...).save(flush: true, failOnError: true)
        //new Rent(...).save(flush: true, failOnError: true)
        //new Rent(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rent.id
    }

    void "test get"() {
        setupData()

        expect:
        rentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rent> rentList = rentService.list(max: 2, offset: 2)

        then:
        rentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rentService.count() == 5
    }

    void "test delete"() {
        Long rentId = setupData()

        expect:
        rentService.count() == 5

        when:
        rentService.delete(rentId)
        sessionFactory.currentSession.flush()

        then:
        rentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rent rent = new Rent()
        rentService.save(rent)

        then:
        rent.id != null
    }
}
