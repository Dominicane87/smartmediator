package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationsRepository extends CrudRepository<OrganizationsEntity, UUID> {

    Optional<OrganizationsEntity> findByInn(String inn);
}
