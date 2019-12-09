package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersOrganizationsEntity;

import java.util.UUID;

@Repository
public interface UsersOrganizationsRepository extends JpaRepository<UsersOrganizationsEntity, UUID> {

//    boolean deleteAllByUserId(UUID user_id);

//    Iterable<UsersOrganizationsEntity> findAllByUserId(UUID user_id);
}
