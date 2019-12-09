package stc21.smartmediator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.model.entity.BuyersEntity;
import stc21.smartmediator.model.repository.BuyersRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
public class Buyer {

    private final BuyersRepository repository;

    @Autowired
    public Buyer(BuyersRepository buyersRepository) {
        this.repository = buyersRepository;
    }

    public BuyersEntity get(UUID id) {
        Optional<BuyersEntity> buyer = repository.findById(id);
        return buyer.orElse(null);
    }

    public ArrayList<BuyersEntity> getAll() {
        Iterable<BuyersEntity> buyers = repository.findAll();
        ArrayList<BuyersEntity> buyerList = new ArrayList<>();
        buyers.forEach(buyerList::add);
        return buyerList;
    }

    @Transactional
    public int deleteAllByOrgId(UUID orgId) {
        Collection<BuyersEntity> buyers = repository.findAllByOrgId(orgId);
        buyers.forEach(x -> delete(x.getId()));
        return buyers.size();
    }

    @Transactional
    public int deleteAllByPricePatternId(UUID patternId) {
        Collection<BuyersEntity> buyers = repository.findAllByPricePatternId(patternId);
        buyers.forEach(x -> delete(x.getId()));
        return buyers.size();
    }

    @Transactional
    public void delete(UUID id) {

        repository.deleteById(id);
    }
}
