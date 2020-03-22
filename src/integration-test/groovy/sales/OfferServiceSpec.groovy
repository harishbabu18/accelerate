package sales

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OfferServiceSpec extends Specification {

    OfferService offerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Offer(...).save(flush: true, failOnError: true)
        //new Offer(...).save(flush: true, failOnError: true)
        //Offer offer = new Offer(...).save(flush: true, failOnError: true)
        //new Offer(...).save(flush: true, failOnError: true)
        //new Offer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //offer.id
    }

    void "test get"() {
        setupData()

        expect:
        offerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Offer> offerList = offerService.list(max: 2, offset: 2)

        then:
        offerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        offerService.count() == 5
    }

    void "test delete"() {
        Long offerId = setupData()

        expect:
        offerService.count() == 5

        when:
        offerService.delete(offerId)
        sessionFactory.currentSession.flush()

        then:
        offerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Offer offer = new Offer()
        offerService.save(offer)

        then:
        offer.id != null
    }
}
