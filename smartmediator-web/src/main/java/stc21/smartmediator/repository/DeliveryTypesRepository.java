package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.DeliveryTypesEntity;

import java.util.UUID;

@Repository
public interface DeliveryTypesRepository extends JpaRepository<DeliveryTypesEntity, UUID> {

}
