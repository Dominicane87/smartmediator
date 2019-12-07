package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import stc21.smartmediator.model.entity.UserStatusesEntity;
import stc21.smartmediator.model.repository.RolesRepository;
import stc21.smartmediator.model.repository.UserRepository;
import stc21.smartmediator.model.entity.UsersEntity;
import stc21.smartmediator.model.repository.UserStatusesRepository;
import stc21.smartmediator.model.service.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final UserStatusesRepository userStatusesRepository;

    @Autowired
    UserController(UserRepository repository,
                   RolesRepository rolesRepository,
                   UserStatusesRepository userStatusesRepository,

                   UserServiceImpl userService) {
        this.userRepository = repository;
        this.rolesRepository = rolesRepository;
        this.userStatusesRepository = userStatusesRepository;

        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UsersEntity> index() {

        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UsersEntity show(@PathVariable String id) {

        return userService.findById(id);
    }

    @PostMapping("/user/search")
    public UsersEntity search(@RequestParam String email) {

        return userService.searchByEmail(email);
    }

    @PostMapping("/user")
    public UsersEntity create(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("full_name") String full_name) {

        return userService.create(email, password, full_name);
    }

//    @PutMapping("/user/{id}")
//    public UsersEntity update(@PathVariable String id, @RequestBody Map<String, String> body) {
//        UUID uuid = UUID.fromString(id);
//        UsersEntity user = userRepository.findById(uuid).orElse(null);
//        if (user == null) {
//            throw new IllegalStateException("User with id = " + id + " not found.");
//        }
//
//        String email = body.get("email");
//        if (email != null) {
//            user.setEmail(email);
//        }
//
//        String password = body.get("password_hash");
//        if (password != null) {
//            user.setPasswordHash(password);
//        }
//
//        String name = body.get("full_name");
//        if (name != null) {
//            user.setFullName(name);
//        }
//
//        String status = body.get("status");
//        if (status != null) {
//            UserStatusesEntity s = userStatusesRepository.findByCode(status);
//            if (s != null) {
//                user.setStatus(s.getId());
//            }
//        }
//        return userRepository.save(user);
//    }
//
//    @DeleteMapping("user/{id}")
//    public boolean delete(@PathVariable String id) {
//        UUID uuid = UUID.fromString(id);
//        userRepository.deleteById(uuid);
//        return true;
//    }
}
