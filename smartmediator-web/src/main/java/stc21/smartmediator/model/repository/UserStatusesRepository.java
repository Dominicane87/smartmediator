package stc21.smartmediator.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.UserStatusesEntity;

import java.util.UUID;

@Repository
public interface UserStatusesRepository extends JpaRepository<UserStatusesEntity, UUID> {

    UserStatusesEntity findByCode(String code);

}
