package sales

import grails.gorm.services.Service

@Service(Offer)
interface OfferService {

    Offer get(Serializable id)

    List<Offer> list(Map args)

    Long count()

    void delete(Serializable id)

    Offer save(Offer offer)

}