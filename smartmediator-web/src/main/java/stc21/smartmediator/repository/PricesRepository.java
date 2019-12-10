package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.PricesEntity;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface PricesRepository extends CrudRepository<PricesEntity, UUID> {

        Collection<PricesEntity> findAllByProductId(UUID id);

        Collection<PricesEntity> findAllByPricePatternId(UUID id);
}
