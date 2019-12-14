package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.PricePatternsEntity;

import java.util.Collection;
import java.util.UUID;

public interface PricePatternsRepository extends JpaRepository<PricePatternsEntity, UUID> {

    Collection<PricePatternsEntity> findBySellerId(UUID id);

    Collection<PricePatternsEntity> findByParentId(UUID id);
}
