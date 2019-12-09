package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersOrganizationsEntity;

import java.util.UUID;

@Repository
public interface UsersOrganizationsRepository extends CrudRepository<UsersOrganizationsEntity, UUID> {
    void deleteAllByOrgId(UUID id);

    Iterable<UsersOrganizationsEntity> findAllByUserId(UUID user_id);

//    boolean deleteAllByUserId(UUID user_id);

//    Iterable<UsersOrganizationsEntity> findAllByUserId(UUID user_id);
}
