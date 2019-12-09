package stc21.smartmediator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stc21.smartmediator.model.entity.*;
import stc21.smartmediator.model.repository.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrganizationController {

//    private final OrganizationsRepository organizationsRepository;
//    private final OrgStatusesRepository orgStatusesRepository;
//
//    @Autowired
//    OrganizationController(OrganizationsRepository repository,
//                            OrgStatusesRepository orgStatusesRepository) {
//        this.organizationsRepository = repository;
//        this.orgStatusesRepository = orgStatusesRepository;
//    }
//
//    @GetMapping("/organization")
//    public Iterable<OrganizationsEntity> index(){
//
//        return organizationsRepository.findAll();
//    }
//
//    @GetMapping("/organization/{id}")
//    public OrganizationsEntity show(@PathVariable String id){
//        UUID uuid = UUID.fromString(id);
//        Optional<OrganizationsEntity> org = organizationsRepository.findById(uuid);
//        return org.orElse(null);
//    }
//
//    @PostMapping("/organization")
//    public OrganizationsEntity create(@RequestBody Map<String, String> body){
//        String full_name = body.get("full_name");
//        String name = body.get("name");
//        String inn = body.get("inn");
//        String address = body.get("address");
//        OrgStatusesEntity os = orgStatusesRepository.findByCode("new");
//        if(os != null) {
//            return organizationsRepository.save(
//                    new OrganizationsEntity(full_name, name, inn, address, os.getId()));
//        } else {
//            return null;
//        }
//    }
//
//    @PutMapping("/organization/{id}")
//    public OrganizationsEntity update(@PathVariable String id, @RequestBody Map<String, String> body){
//        UUID uuid = UUID.fromString(id);
//        OrganizationsEntity organization = organizationsRepository.findById(uuid).orElse(null);
//        if(organization == null) {
//            throw new IllegalStateException("Organization with id = " + id + " not found.");
//        }
//
//        String full_name = body.get("full_name");
//        if(full_name != null) {
//            organization.setFullName(full_name);
//        }
//
//        String name = body.get("name");
//        if(name != null) {
//            organization.setName(name);
//        }
//
//        String inn = body.get("inn");
//        if(inn != null) {
//            organization.setInn(inn);
//        }
//
//        String address = body.get("address");
//        if(address != null) {
//            organization.setAddress(address);
//        }
//
//        String status = body.get("status");
//        if(status != null) {
//            OrgStatusesEntity s = orgStatusesRepository.findByCode(status);
//            if(s != null) {
//                organization.setStatus(s.getId());
//            }
//        }
//        return organizationsRepository.save(organization);
//    }
//
//    @DeleteMapping("organization/{id}")
//    public boolean delete(@PathVariable String id){
//        UUID uuid = UUID.fromString(id);
//        organizationsRepository.deleteById(uuid);
//        return true;
//    }
}