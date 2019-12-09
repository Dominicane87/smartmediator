package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.UUID;

public interface OrganizationsRepository extends JpaRepository<OrganizationsEntity, UUID> {
}
