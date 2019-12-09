package stc21.smartmediator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.model.entity.OrganizationsEntity;
import stc21.smartmediator.model.entity.SellersEntity;
import stc21.smartmediator.model.repository.BuyersRepository;
import stc21.smartmediator.model.repository.PricePatternsRepository;
import stc21.smartmediator.model.repository.SellersRepository;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class Seller {

    private final SellersRepository repository;
    private final PricePattern pricePattern;

    @Autowired
    public Seller(SellersRepository repository,
                  PricePattern pricePattern) {
        this.repository = repository;
        this.pricePattern = pricePattern;
    }

    public SellersEntity create(OrganizationsEntity organization) {
        SellersEntity newSeller = new SellersEntity(organization.getId());
        return repository.save(newSeller);
    }

    public SellersEntity get(UUID id) {
        Optional<SellersEntity> seller = repository.findById(id);
        return seller.orElse(null);
    }

    public ArrayList<SellersEntity> getAll() {
        Iterable<SellersEntity> sellers = repository.findAll();
        ArrayList<SellersEntity> userList = new ArrayList<>();
        sellers.forEach(userList::add);
        return userList;
    }

    @Transactional
    public int deleteAllByOrgId(UUID orgId) {
        Collection<SellersEntity> sellers = repository.findByOrgId(orgId);
        sellers.forEach(
                x -> delete(x.getId()));
        return sellers.size();
    }

    @Transactional
    public void delete(UUID id) {
        pricePattern.deleteAllBySellerId(id);
        repository.deleteById(id);
    }
}
