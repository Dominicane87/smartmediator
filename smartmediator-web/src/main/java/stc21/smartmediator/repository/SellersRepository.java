package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.SellersEntity;

import java.util.Collection;
import java.util.UUID;

public interface SellersRepository extends JpaRepository<SellersEntity, UUID> {

    Collection<SellersEntity> findByOrgId(UUID id);

}
