package stc21.smartmediator.model.repository;

import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.model.entity.OrganizationsEntity;

import java.util.UUID;

public interface OrganizationsRepository extends CrudRepository<OrganizationsEntity, UUID> {
}
