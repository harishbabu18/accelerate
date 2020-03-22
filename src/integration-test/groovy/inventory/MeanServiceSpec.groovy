package inventory

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MeanServiceSpec extends Specification {

    MeanService meanService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mean(...).save(flush: true, failOnError: true)
        //new Mean(...).save(flush: true, failOnError: true)
        //Mean mean = new Mean(...).save(flush: true, failOnError: true)
        //new Mean(...).save(flush: true, failOnError: true)
        //new Mean(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mean.id
    }

    void "test get"() {
        setupData()

        expect:
        meanService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mean> meanList = meanService.list(max: 2, offset: 2)

        then:
        meanList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        meanService.count() == 5
    }

    void "test delete"() {
        Long meanId = setupData()

        expect:
        meanService.count() == 5

        when:
        meanService.delete(meanId)
        sessionFactory.currentSession.flush()

        then:
        meanService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mean mean = new Mean()
        meanService.save(mean)

        then:
        mean.id != null
    }
}
