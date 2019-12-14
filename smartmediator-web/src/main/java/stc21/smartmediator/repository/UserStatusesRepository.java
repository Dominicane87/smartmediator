package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UserStatusesEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserStatusesRepository extends JpaRepository<UserStatusesEntity, UUID> {

    // some custom queries

    default List<UserStatusesEntity> search(String query) {
        return null;
    }

    UserStatusesEntity findByCode(String code);

}
