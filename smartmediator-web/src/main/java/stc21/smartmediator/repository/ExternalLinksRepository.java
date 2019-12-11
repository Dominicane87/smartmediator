package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.ExternalLinksEntity;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ExternalLinksRepository extends CrudRepository<ExternalLinksEntity, UUID> {

    Collection<ExternalLinksEntity> findAllBySellerId(UUID id);

    Collection<ExternalLinksEntity> findAllByProductId(UUID id);
}
