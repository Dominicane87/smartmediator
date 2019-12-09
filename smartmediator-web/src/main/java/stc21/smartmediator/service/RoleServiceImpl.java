package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.repository.RolesRepository;

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
