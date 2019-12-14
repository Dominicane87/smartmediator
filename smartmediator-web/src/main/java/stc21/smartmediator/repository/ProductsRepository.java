package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.ProductsEntity;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, UUID> {

    Collection<ProductsEntity> findAllBySellerId(UUID sellerId);
}
