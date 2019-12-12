package stc21.smartmediator.service;

import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.ExternalLinksEntity;
import stc21.smartmediator.entity.ProductsEntity;
import stc21.smartmediator.entity.SellersEntity;
import stc21.smartmediator.repository.ExternalLinksRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component
public class ExternalLink {

    public final String codeFieldName = "code";

    public final ExternalLinksRepository repository;

    public ExternalLink(ExternalLinksRepository repository) {
        this.repository = repository;
    }

    public ExternalLinksEntity create(String code, SellersEntity seller, ProductsEntity product) {
        ExternalLinksEntity link = new ExternalLinksEntity(code, seller.getId(), product.getId());
        return repository.save(link);
    }

    public ArrayList<ExternalLinksEntity> getAll() {
        Iterable<ExternalLinksEntity> links = repository.findAll();
        ArrayList<ExternalLinksEntity> linkList = new ArrayList<>();
        links.forEach(linkList::add);
        return linkList;
    }

    public ExternalLinksEntity update(UUID id, Map<String, String> fields) {

        ExternalLinksEntity link = repository.findById(id).orElse(null);
        if (link == null) {
            throw new IllegalStateException("ExternalLink with id = " + id + " not found.");
        }

        String code = fields.get(codeFieldName);
        if (code != null) {
            link.setCode(code);
        }

        return repository.save(link);
    }

    @Transactional
    public int deleteAllByProductId(UUID productId) {
        Collection<ExternalLinksEntity> links = repository.findAllByProductId(productId);
        links.forEach(x -> delete(x.getId()));
        return links.size();
    }

    @Transactional
    public int deleteBySellerId(UUID sellerId) {
        Collection<ExternalLinksEntity> links = repository.findAllByProductId(sellerId);
        links.forEach(x -> delete(x.getId()));
        return links.size();
    }


    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
