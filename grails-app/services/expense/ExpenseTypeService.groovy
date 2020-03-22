package expense

import grails.gorm.services.Service

@Service(ExpenseType)
interface ExpenseTypeService {

    ExpenseType get(Serializable id)

    List<ExpenseType> list(Map args)

    Long count()

    void delete(Serializable id)

    ExpenseType save(ExpenseType expenseType)

}