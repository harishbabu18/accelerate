package expense

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExpenseTypeServiceSpec extends Specification {

    ExpenseTypeService expenseTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ExpenseType(...).save(flush: true, failOnError: true)
        //new ExpenseType(...).save(flush: true, failOnError: true)
        //ExpenseType expenseType = new ExpenseType(...).save(flush: true, failOnError: true)
        //new ExpenseType(...).save(flush: true, failOnError: true)
        //new ExpenseType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //expenseType.id
    }

    void "test get"() {
        setupData()

        expect:
        expenseTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ExpenseType> expenseTypeList = expenseTypeService.list(max: 2, offset: 2)

        then:
        expenseTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        expenseTypeService.count() == 5
    }

    void "test delete"() {
        Long expenseTypeId = setupData()

        expect:
        expenseTypeService.count() == 5

        when:
        expenseTypeService.delete(expenseTypeId)
        sessionFactory.currentSession.flush()

        then:
        expenseTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ExpenseType expenseType = new ExpenseType()
        expenseTypeService.save(expenseType)

        then:
        expenseType.id != null
    }
}
