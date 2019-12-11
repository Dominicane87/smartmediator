package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.TraceOrdersEntity;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface TraceOrdersRepository extends CrudRepository<TraceOrdersEntity, UUID> {

    Collection<TraceOrdersEntity> findAllByAuthor(UUID authorId);

    Collection<TraceOrdersEntity> findAllByOrderId(UUID orderId);
}
