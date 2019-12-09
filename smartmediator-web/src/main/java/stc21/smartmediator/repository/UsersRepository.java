package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersEntity;
import stc21.smartmediator.entity.UsersOrganizationsEntity;

import javax.transaction.Transactional;
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
