package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersRolesEntity;

import java.util.UUID;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRolesEntity, UUID> {

}
