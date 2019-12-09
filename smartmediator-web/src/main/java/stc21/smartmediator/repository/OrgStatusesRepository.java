package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrgStatusesEntity;
import stc21.smartmediator.entity.UserStatusesEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrgStatusesRepository extends JpaRepository<OrgStatusesEntity, UUID> {

    // some custom queries

    default List<UserStatusesEntity> search(String query) {
        return null;
    }

    OrgStatusesEntity findByCode(String code);
}
