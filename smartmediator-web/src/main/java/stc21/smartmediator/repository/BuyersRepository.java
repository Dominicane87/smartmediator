package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.BuyersEntity;

import java.util.Collection;
import java.util.UUID;

public interface BuyersRepository extends JpaRepository<BuyersEntity, UUID> {

    Collection<BuyersEntity> findAllByOrgId(UUID id);

    Collection<BuyersEntity> findAllByPricePatternId(UUID id);


}
