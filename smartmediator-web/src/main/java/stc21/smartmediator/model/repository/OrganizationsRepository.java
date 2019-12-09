package stc21.smartmediator.model.repository;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.OrganizationsEntity;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface OrganizationsRepository extends CrudRepository<OrganizationsEntity, UUID> {

//    @Transactional
//    default void delete(UUID id,
//                        UsersOrganizationsRepository usersOrgRepository,
//                        LogisticsPointsRepository logisticsPointsRepository,
//                        SellersRepository sellersRepository,
//                        PricePatternsRepository pricePatternsRepository,
//                        BuyersRepository buyersRepository) {
//        usersOrgRepository.deleteAllByOrgId(id);
//        logisticsPointsRepository.deleteAllByOrgId(id);
//        sellersRepository.deleteAllByOrgId(id, pricePatternsRepository, buyersRepository);
//        deleteById(id);
//    }
}
