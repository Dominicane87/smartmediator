package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import stc21.smartmediator.model.entity.RolesEntity;
import stc21.smartmediator.model.entity.UserStatusesEntity;
import stc21.smartmediator.model.repository.RolesRepository;
import stc21.smartmediator.model.repository.UserRepository;
import stc21.smartmediator.model.entity.UsersEntity;
import stc21.smartmediator.model.repository.UserStatusesRepository;

import javax.management.relation.RoleList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final UserStatusesRepository userStatusesRepository;

    @Autowired
    UserController(UserRepository repository,
                   RolesRepository rolesRepository,
                   UserStatusesRepository userStatusesRepository) {
        this.userRepository = repository;
        this.rolesRepository = rolesRepository;
        this.userStatusesRepository = userStatusesRepository;
    }

    @GetMapping("/user")
    public List<UsersEntity> index(){

        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UsersEntity show(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        Optional<UsersEntity> ou = userRepository.findById(uuid);
        return ou.orElse(null);
    }

    @PostMapping("/user/search")
    public List<UsersEntity> search(@RequestBody String email){

        return userRepository.searchByEmail(email);
    }

    @PostMapping("/user")
    public UsersEntity create(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password_hash = body.get("password_hash");
        String full_name = body.get("full_name");
        RolesEntity r = rolesRepository.findByCode("user");
        UserStatusesEntity us = userStatusesRepository.findByCode("new");
        if(r != null && us != null) {
            return userRepository.save(
                    new UsersEntity(email, password_hash, full_name, r.getId(), us.getId()));
        } else {
            return null;
        }
    }

    @PutMapping("/user/{id}")
    public UsersEntity update(@PathVariable String id, @RequestBody Map<String, String> body){
        UUID uuid = UUID.fromString(id);
        UsersEntity user = userRepository.findById(uuid).orElse(null);
        if(user == null) {
            throw new IllegalStateException("User with id = " + id + " not found.");
        }

        String email = body.get("email");
        if(email != null) {
            user.setEmail(email);
        }

        String password = body.get("password_hash");
        if(password != null) {
            user.setPasswordHash(password);
        }

        String name = body.get("full_name");
        if(name != null) {
            user.setFullName(name);
        }

        String status = body.get("status");
        if(status != null) {
            UserStatusesEntity s = userStatusesRepository.findByCode(status);
            if(s != null) {
                user.setStatus(s.getId());
            }
        }
        return userRepository.save(user);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        userRepository.deleteById(uuid);
        return true;
    }
}
