package stc21.smartmediator.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.RolesEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, UUID> {

    // some custom queries

    default List<RolesEntity> search(String query) {
        return null;
    }
}
