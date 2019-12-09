package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, UUID> {
//    UsersEntity save(UsersEntity newUser, List<UUID> orgIds, UsersOrganizationsRepository userOrgRepository);

    Optional<Object> findByEmail(String email);

//    void delete(UUID id, UsersOrganizationsRepository userOrgRepository);
}
