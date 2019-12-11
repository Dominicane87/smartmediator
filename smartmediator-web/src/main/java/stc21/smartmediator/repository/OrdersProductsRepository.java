package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrdersProductsEntity;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface OrdersProductsRepository extends CrudRepository<OrdersProductsEntity, UUID> {

    Collection<OrdersProductsEntity> findAllByOrderId(UUID id);

    Collection<OrdersProductsEntity> findAllByProductId(UUID id);
}
