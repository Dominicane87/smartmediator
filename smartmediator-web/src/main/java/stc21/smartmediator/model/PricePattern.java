package stc21.smartmediator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.model.entity.PricePatternsEntity;
import stc21.smartmediator.model.entity.SellersEntity;
import stc21.smartmediator.model.repository.BuyersRepository;
import stc21.smartmediator.model.repository.PricePatternsRepository;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class PricePattern {

    private final String codeFieldName = "code";
    private final String nameFieldName = "name";
    private final String noteFieldName = "note";
    private final String deletedFieldName = "deleted";

    private final PricePatternsRepository repository;
    private final Buyer buyer;

    @Autowired
    public PricePattern(PricePatternsRepository repository,
                        Buyer buyer) {
        this.repository = repository;
        this.buyer = buyer;
    }

    public PricePatternsEntity create(String code,
                                      String name,
                                      PricePatternsEntity parent,
                                      String note,
                                      SellersEntity seller) {
        PricePatternsEntity newPattern = new PricePatternsEntity(code, name, parent.getId(), note, seller.getId());
        return repository.save(newPattern);
    }

    public PricePatternsEntity get(UUID id) {
        Optional<PricePatternsEntity> pattern = repository.findById(id);
        return pattern.orElse(null);
    }

    public ArrayList<PricePatternsEntity> getAll() {
        Iterable<PricePatternsEntity> patterns = repository.findAll();
        ArrayList<PricePatternsEntity> patternList = new ArrayList<>();
        patterns.forEach(patternList::add);
        return patternList;
    }

    public PricePatternsEntity update(UUID id, Map<String, String> fields) {

        PricePatternsEntity point = repository.findById(id).orElse(null);
        if(point == null) {
            throw new IllegalStateException("Pattern with id = " + id + " not found.");
        }

        String code = fields.get(codeFieldName);
        if(code != null) {
            point.setCode(code);
        }

        String name = fields.get(nameFieldName);
        if(name != null) {
            point.setName(name);
        }

        String note = fields.get(noteFieldName);
        if(note != null) {
            point.setNote(note);
        }

        String deleted = fields.get(deletedFieldName);
        if(deleted != null) {
            point.setDeleted(Boolean.parseBoolean(deleted));
        }
        return repository.save(point);
    }

    @Transactional
    public int deleteAllBySellerId(UUID sellerId) {
        Collection<PricePatternsEntity> patterns = repository.findBySellerId(sellerId);
        patterns.forEach(x -> {
            UUID pattern_id = x.getId();
            if(repository.existsById(pattern_id)) {
                delete(pattern_id);
            }
        });
        return patterns.size();
    }

    @Transactional
    public void delete(UUID id) {
        ArrayDeque<UUID> temp = new ArrayDeque<UUID>();
        temp.addFirst(id);

        ArrayDeque<UUID> forDelete = new ArrayDeque<>();
        forDelete.addFirst(id);
        while(temp.size() != 0) {
            UUID lastId = temp.removeLast();
            Collection<PricePatternsEntity> children = repository.findByParentId(lastId);
            children.forEach(x -> {
                forDelete.addFirst(x.getId());
                temp.addFirst(x.getId());
            });
        }

        forDelete.forEach(x -> {
            buyer.deleteAllByPricePatternId(x);
            repository.deleteById(x);
        });
    }
}
