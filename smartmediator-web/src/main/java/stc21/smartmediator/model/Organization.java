package stc21.smartmediator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.model.entity.OrgStatusesEntity;
import stc21.smartmediator.model.entity.OrganizationsEntity;
import stc21.smartmediator.model.repository.*;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class Organization {

    private final String fullNameFieldName = "full_name";
    private final String nameFieldName = "name";
    private final String innFieldName = "inn";
    private final String addressFieldName = "address";
    private final String statusFieldName = "status";


    private final OrganizationsRepository repository;
    private final UsersOrganizationsRepository usersOrgRepository;
    private final OrgStatusesRepository orgStatusesRepository;
    private final LogisticsPointsRepository logisticsPointsRepository;
    private final PricePatternsRepository pricePatternsRepository;
    //private final SellersRepository sellersRepository;
    private final Seller seller;
    private final BuyersRepository buyersRepository;

    @Autowired
    public Organization(OrganizationsRepository repository,
                        UsersOrganizationsRepository userOrgRepository,
                        OrgStatusesRepository orgStatusesRepository,
                        LogisticsPointsRepository logisticsPointsRepository,
                        PricePatternsRepository pricePatternsRepository,
                        Seller seller,
                        BuyersRepository buyersRepository) {
        this.repository = repository;
        this.usersOrgRepository = userOrgRepository;
        this.orgStatusesRepository = orgStatusesRepository;
        this.logisticsPointsRepository = logisticsPointsRepository;
        this.pricePatternsRepository = pricePatternsRepository;
        this.seller = seller;
        this.buyersRepository = buyersRepository;
    }

    private UUID newOrgStatusId;
    private UUID getNewOrgStatusId() {
        if(newOrgStatusId == null) {
            OrgStatusesEntity os = orgStatusesRepository.findByCode("new");
            newOrgStatusId = os.getId();
        }
        return newOrgStatusId;
    }

    public OrganizationsEntity create(String fullName, String name, String inn, String address) {
        OrganizationsEntity newOrg = new OrganizationsEntity(fullName, name, inn, address, getNewOrgStatusId());
        return repository.save(newOrg);
    }

    public OrganizationsEntity get(UUID id) {
        Optional<OrganizationsEntity> org = repository.findById(id);
        return org.orElse(null);
    }

    public OrganizationsEntity findByInn(String inn) {
        return repository.findByInn(inn).orElse(null);
    }

    public ArrayList<OrganizationsEntity> getAll() {
        Iterable<OrganizationsEntity> orgs = repository.findAll();
        ArrayList<OrganizationsEntity> orgList = new ArrayList<>();
        orgs.forEach(orgList::add);
        return orgList;
    }

    public OrganizationsEntity update(UUID id, Map<String, String> fields) {
        OrganizationsEntity organization = repository.findById(id).orElse(null);
        if(organization == null) {
            throw new IllegalStateException("Organization with id = " + id + " not found.");
        }

        String fullName = fields.get(fullNameFieldName);
        if(fullName != null) {
            organization.setFullName(fullName);
        }

        String name = fields.get(nameFieldName);
        if(name != null) {
            organization.setName(name);
        }

        String inn = fields.get(innFieldName);
        if(inn != null) {
            organization.setInn(inn);
        }

        String address = fields.get(addressFieldName);
        if(address != null) {
            organization.setAddress(address);
        }

        String status = fields.get(statusFieldName);
        if(status != null) {
            OrgStatusesEntity s = orgStatusesRepository.findByCode(status);
            if(s != null) {
                organization.setStatus(s.getId());
            }
        }
        return repository.save(organization);
    }

    @Transactional
    public void delete(UUID id) {
        usersOrgRepository.deleteAllByOrgId(id);
        logisticsPointsRepository.deleteAllByOrgId(id);
        seller.deleteAllByOrgId(id);
        repository.deleteById(id);
    }
}
