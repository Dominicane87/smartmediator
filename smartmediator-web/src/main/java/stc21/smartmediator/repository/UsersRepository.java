package stc21.smartmediator.repository;

import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {
//    List<UsersEntity> searchByEmail(String email);

//    Optional<UsersEntity> findByEmail(String email);

//    void delete(UUID id, UsersOrganizationsRepository usersOrgRepository);

}
