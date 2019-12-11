package stc21.smartmediator.repository;

import org.springframework.data.repository.CrudRepository;
import stc21.smartmediator.entity.LogisticsPointsEntity;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

public interface LogisticsPointsRepository extends CrudRepository<LogisticsPointsEntity, UUID> {

    Collection<LogisticsPointsEntity> findByOrgId(UUID id);

    @Transactional
    default int deleteAllByOrgId(UUID orgId) {
        Collection<LogisticsPointsEntity> points = findByOrgId(orgId);
        points.forEach(x -> delete(x.getId()));
        return points.size();
    }

    @Transactional
    default void delete(UUID id) {
        deleteById(id);
    }
}
