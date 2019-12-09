package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationsRepository extends CrudRepository<OrganizationsEntity, UUID> {
    Optional<Object> findByInn(String inn);
}
