package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.PricePatternsEntity;
import stc21.smartmediator.entity.PricePatternsEntity;

import javax.transaction.Transactional;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.UUID;

public interface PricePatternsRepository extends CrudRepository<PricePatternsEntity, UUID> {

    Collection<PricePatternsEntity> findBySellerId(UUID id);

    Collection<PricePatternsEntity> findByParentId(UUID id);
}
