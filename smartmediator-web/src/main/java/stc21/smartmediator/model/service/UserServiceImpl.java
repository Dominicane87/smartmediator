package stc21.smartmediator.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.model.entity.UserStatusesEntity;
import stc21.smartmediator.model.entity.UsersEntity;
import stc21.smartmediator.model.repository.RolesRepository;
import stc21.smartmediator.model.repository.UserRepository;
import stc21.smartmediator.model.repository.UserStatusesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UserStatusesRepository userStatusesRepository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
        this.rolesRepository = rolesRepository;
        this.userStatusesRepository = userStatusesRepository;
    }

    @Override
    public List<UsersEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UsersEntity findById(String id) {
        Optional<UsersEntity> usersEntityOptional = repository.findById(UUID.fromString(id));

        return usersEntityOptional.orElse(null);
    }

    @Override
    public UsersEntity searchByEmail(String email) {
        Optional<UsersEntity> usersEntityOptional = repository.findByEmail(email);

        return usersEntityOptional.orElse(null);
    }

    @Override
    public UsersEntity create(String email, String pass, String full_name) {
        UsersEntity template = new UsersEntity();
        template.setEmail(email);
        template.setPasswordHash(pass);
        template.setFullName(full_name);
//        template.setStatus(userStatusesRepository.findByCode("new").getId());
//        template.setRole(rolesRepository.findByCode("user").getId());
//
//        return repository.save(new UsersEntity());

        return null;
    }
}

//    @Override
//    public Optional<UsersEntity> create(Map<String, String> params) {
//        String email = params.get("email");
//        String password_hash = params.get("password_hash");
//        String full_name = params.get("full_name");
//        RolesEntity r = rolesRepository.findByCode("user");
//
//        UserStatusesRepository us = userStatusesRepository.findByCode("new");
////        if(r != null && us != null) {
//            return userRepository.save(
//                    new UsersEntity(email, password_hash, full_name, r.getId(), us.getId()));
//        } else {
//            return null;
//        }
//
//        return Optional.empty();
//    }
