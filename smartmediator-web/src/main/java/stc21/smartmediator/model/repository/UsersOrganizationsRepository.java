package stc21.smartmediator.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.UsersOrganizationsEntity;

import java.util.UUID;

@Repository
public interface UsersOrganizationsRepository extends CrudRepository<UsersOrganizationsEntity, UUID> {

    int deleteAllByUserId(UUID userId);

    int deleteAllByOrgId(UUID orgId);

    Iterable<UsersOrganizationsEntity> findAllByUserId(UUID user_id);
}
