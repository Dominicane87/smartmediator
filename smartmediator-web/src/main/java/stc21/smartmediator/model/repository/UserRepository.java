package stc21.smartmediator.model.repository;

import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    // some custom queries

    default List<UsersEntity> searchByEmail(String email) {
        return null;
    }
}
