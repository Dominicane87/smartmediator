package stc21.smartmediator.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.model.entity.RolesEntity;
import stc21.smartmediator.model.repository.RolesRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RolesService {

    @Autowired
    private RolesRepository repository;

    public RoleServiceImpl(RolesRepository repository) {
        this.repository = repository;
    }

//    @Override
//    public List<RolesEntity> findByCode(String code) {
//        return (List<RolesEntity>) repository.findByCode(code);
//    }
}
