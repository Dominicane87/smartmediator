package stc21.smartmediator.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import stc21.smartmediator.model.entity.UsersOrganizationsEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, UUID> {

    // some custom queries

    Optional<UsersEntity> findByEmail(String email);

    @Transactional
    default void delete(UUID id, UsersOrganizationsRepository usersOrgRepository) {
        usersOrgRepository.deleteAllByUserId(id);
        deleteById(id);
    }

    @Transactional
    default UsersEntity save(UsersEntity user,
                             Iterable<UUID> orgIds,
                             UsersOrganizationsRepository usersOrgRepository) {
        UsersEntity result = save(user);
        orgIds.forEach(x -> {
            UsersOrganizationsEntity userOrg = new UsersOrganizationsEntity(result.getId(), x);
            usersOrgRepository.save(userOrg);
        });
        return result;
    }
}
