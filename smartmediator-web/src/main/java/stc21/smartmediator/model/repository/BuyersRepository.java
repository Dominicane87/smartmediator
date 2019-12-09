package stc21.smartmediator.model.repository;

import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.model.entity.BuyersEntity;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

public interface BuyersRepository extends CrudRepository<BuyersEntity, UUID> {

    Collection<BuyersEntity> findAllByOrgId(UUID id);

    Collection<BuyersEntity> findAllByPricePatternId(UUID id);
}
