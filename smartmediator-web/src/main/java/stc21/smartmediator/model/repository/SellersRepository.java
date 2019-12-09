package stc21.smartmediator.model.repository;

import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.model.entity.SellersEntity;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

public interface SellersRepository extends CrudRepository<SellersEntity, UUID> {

    Collection<SellersEntity> findByOrgId(UUID id);

}
