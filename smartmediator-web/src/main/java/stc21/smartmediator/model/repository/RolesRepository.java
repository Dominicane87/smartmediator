package stc21.smartmediator.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.RolesEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, UUID> {

    // some custom queries

    default List<RolesEntity> search(String query) {
        return null;
    }

    RolesEntity findByCode(String code);
}
