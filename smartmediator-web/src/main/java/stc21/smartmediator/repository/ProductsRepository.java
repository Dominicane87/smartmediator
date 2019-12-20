package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.DTO.Order;
import stc21.smartmediator.entity.ProductsEntity;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, UUID> {

    Collection<ProductsEntity> findAllBySellerId(UUID sellerId);

    //Найти все продукты по поставщику
    @Query("select products.name, p.cost, products.quantity from products left join prices p on products.id = p.product_id where products.seller_id=:id")
    Collection<Order> findAllBySeller(@Param("id") UUID uuid);
}
