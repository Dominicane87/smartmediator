package stc21.smartmediator.model.repository;

import org.springframework.stereotype.Repository;
import stc21.smartmediator.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // some custom queries

    default List<User> searchByEmail(String email) {
        return null;
    }
}
