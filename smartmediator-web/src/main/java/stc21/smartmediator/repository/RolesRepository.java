package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.RolesEntity;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, UUID> {

//    RolesEntity findByCode(String code);
}
