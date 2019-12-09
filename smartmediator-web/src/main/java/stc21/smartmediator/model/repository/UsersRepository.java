package stc21.smartmediator.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import stc21.smartmediator.model.entity.UsersOrganizationsEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {
//    List<UsersEntity> searchByEmail(String email);

//    Optional<UsersEntity> findByEmail(String email);

//    void delete(UUID id, UsersOrganizationsRepository usersOrgRepository);

}
