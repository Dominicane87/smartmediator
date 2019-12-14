package stc21.smartmediator.rest;

import org.springframework.web.bind.annotation.*;

import stc21.smartmediator.repository.*;

@RestController
public class UserController {

//    private final UsersRepository usersRepository;
//    private final RolesRepository rolesRepository;
//    private final UserStatusesRepository userStatusesRepository;
//    private final UsersOrganizationsRepository usersOrgRepository;
//
//    @Autowired
//    UserController(UsersRepository repository,
//                   RolesRepository rolesRepository,
//                   UserStatusesRepository userStatusesRepository,
//                   UsersOrganizationsRepository usersOrgRepository) {
//        this.usersRepository = repository;
//        this.rolesRepository = rolesRepository;
//        this.userStatusesRepository = userStatusesRepository;
//        this.usersOrgRepository = usersOrgRepository;
//    }
//
//    @GetMapping("/user")
//    public Iterable<UsersEntity> index(){
//
//        return usersRepository.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    public UsersEntity show(@PathVariable String id){
//        UUID uuid = UUID.fromString(id);
//        Optional<UsersEntity> ou = usersRepository.findById(uuid);
//        return ou.orElse(null);
//    }
//
//    @PostMapping("/user/search")
//    public List<UsersEntity> search(@RequestBody String email){
//
//        //return userRepository.searchByEmail(email);
//        return null;
//
//    }
//
//    @PostMapping("/user")
//    public UsersEntity create(@RequestBody Map<String, String> body){
//        String email = body.get("email");
//        String password_hash = body.get("password_hash");
//        String full_name = body.get("full_name");
//        RolesEntity r = rolesRepository.findByCode("user");
//        UserStatusesEntity us = userStatusesRepository.findByCode("new");
//        if(r != null && us != null) {
//            return usersRepository.save(
//                    new UsersEntity(email, password_hash, full_name, r.getId(), us.getId()));
//        } else {
//            return null;
//        }
//    }
//
//    @PutMapping("/user/{id}")
//    public UsersEntity update(@PathVariable String id, @RequestBody Map<String, String> body){
//        UUID uuid = UUID.fromString(id);
//        UsersEntity user = usersRepository.findById(uuid).orElse(null);
//        if(user == null) {
//            throw new IllegalStateException("User with id = " + id + " not found.");
//        }
//
//        String email = body.get("email");
//        if(email != null) {
//            user.setEmail(email);
//        }
//
//        String password = body.get("password_hash");
//        if(password != null) {
//            user.setPassword(password);
//        }
//
//        String name = body.get("full_name");
//        if(name != null) {
//            user.setUsername(name);
//        }
//
//        String status = body.get("status");
//        if(status != null) {
//            UserStatusesEntity s = userStatusesRepository.findByCode(status);
//            if(s != null) {
//                user.setStatus(s.getId());
//            }
//        }
//        return usersRepository.save(user);
//    }
//
//    @DeleteMapping("user/{id}")
//    public boolean delete(@PathVariable String id){
//        UUID uuid = UUID.fromString(id);
//        //userRepository.deleteById(uuid);
//        usersRepository.delete(uuid, usersOrgRepository);
//        return true;
//    }
}
