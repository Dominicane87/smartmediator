package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrderStatusesEntity;

import java.util.UUID;

@Repository
public interface OrderStatusesRepository extends CrudRepository<OrderStatusesEntity, UUID> {

}
