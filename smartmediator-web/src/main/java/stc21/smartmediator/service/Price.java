package stc21.smartmediator.service;

import org.postgresql.util.PGmoney;
import stc21.smartmediator.entity.PricesEntity;
import stc21.smartmediator.repository.PricesRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class Price {

    private final String costFieldName = "cost";

    private final PricesRepository repository;

    public Price(PricesRepository repository) {
        this.repository = repository;
    }

    public ArrayList<PricesEntity> getAll() {
        Iterable<PricesEntity> prices = repository.findAll();
        ArrayList<PricesEntity> priceList = new ArrayList<>();
        prices.forEach(priceList::add);
        return priceList;
    }

    public PricesEntity update(UUID id, Map<String, String> fields) throws SQLException {

        PricesEntity price = repository.findById(id).orElse(null);
        if(price == null) {
            throw new IllegalStateException("Price with id = " + id + " not found.");
        }

        String cost = fields.get(costFieldName);
        if(cost != null) {
            PGmoney money = new PGmoney();
            money.setValue(cost);
            price.setCost(money);
        }

        return repository.save(price);
    }

    @Transactional
    public int deleteByProductId(UUID productId) {
        Collection<PricesEntity> prices = repository.findAllByProductId(productId);
        prices.forEach(
                x -> delete(x.getId()));
        return prices.size();
    }

    @Transactional
    public int deleteByPricePatternId(UUID patternId) {
        Collection<PricesEntity> prices = repository.findAllByPricePatternId(patternId);
        prices.forEach(
                x -> delete(x.getId()));
        return prices.size();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
