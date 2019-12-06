package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import stc21.smartmediator.model.repository.UserRepository;
import stc21.smartmediator.model.entity.UsersEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @GetMapping("/user")
    public List<UsersEntity> index(){

        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UsersEntity show(@PathVariable String id){
        Integer Id = Integer.parseInt(id);
        Optional<UsersEntity> ou = userRepository.findById(Id);
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
        return userRepository.save(
                new UsersEntity(email, password_hash, full_name));
    }

    @PutMapping("/user/{id}")
    public UsersEntity update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        UsersEntity user = userRepository.findById(blogId).orElse(null);
        if(user == null) {
            return null;
        }
        user.setEmail(body.get("email"));
        user.setPasswordHash(body.get("password_hash"));
        user.setFullName(body.get("full_name"));
        return userRepository.save(user);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        userRepository.deleteById(blogId);
        return true;
    }
}
