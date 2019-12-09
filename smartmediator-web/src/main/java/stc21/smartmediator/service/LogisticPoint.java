package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.LogisticsPointsEntity;
import stc21.smartmediator.entity.OrganizationsEntity;
import stc21.smartmediator.repository.LogisticsPointsRepository;

import java.util.*;

@Component
public class LogisticPoint {

    private final String codeFieldName = "code";
    private final String nameFieldName = "name";
    private final String addressFieldName = "address";
    private final String deletedFieldName = "deleted";


    private final LogisticsPointsRepository repository;

    @Autowired
    public LogisticPoint(LogisticsPointsRepository logisticsPointsRepository) {
        this.repository = logisticsPointsRepository;
    }

    public LogisticsPointsEntity create(String code,
                                        String name,
                                        String address,
                                        OrganizationsEntity organization) {
        LogisticsPointsEntity newPoint = new LogisticsPointsEntity(code, name, address, organization.getId());
        return repository.save(newPoint);
    }

    public LogisticsPointsEntity get(UUID id) {
        Optional<LogisticsPointsEntity> point = repository.findById(id);
        return point.orElse(null);
    }

    public ArrayList<LogisticsPointsEntity> getAll() {
        Iterable<LogisticsPointsEntity> points = repository.findAll();
        ArrayList<LogisticsPointsEntity> pointList = new ArrayList<>();
        points.forEach(pointList::add);
        return pointList;
    }

    public LogisticsPointsEntity update(UUID id, Map<String, String> fields) {

        LogisticsPointsEntity point = repository.findById(id).orElse(null);
        if(point == null) {
            throw new IllegalStateException("Point with id = " + id + " not found.");
        }

        String code = fields.get(codeFieldName);
        if(code != null) {
            point.setCode(code);
        }

        String name = fields.get(nameFieldName);
        if(name != null) {
            point.setName(name);
        }

        String address = fields.get(addressFieldName);
        if(address != null) {
            point.setAddress(address);
        }

        String deleted = fields.get(deletedFieldName);
        if(deleted != null) {
            point.setDeleted(Boolean.parseBoolean(deleted));
        }
        return repository.save(point);
    }

    public void delete(UUID id) {
        repository.delete(id);
    }
}
