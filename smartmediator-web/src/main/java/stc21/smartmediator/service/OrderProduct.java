package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.OrdersProductsEntity;
import stc21.smartmediator.repository.OrdersProductsRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderProduct {

    private final String amountFieldName = "amount";
    private final String noteFieldName = "note";

    private final OrdersProductsRepository repository;

    @Autowired
    public OrderProduct(OrdersProductsRepository repository) {
        this.repository = repository;
    }

    public ArrayList<OrdersProductsEntity> getAll() {
        Iterable<OrdersProductsEntity> ordersProducts = repository.findAll();
        ArrayList<OrdersProductsEntity> orderProductsList = new ArrayList<>();
        ordersProducts.forEach(orderProductsList::add);
        return orderProductsList;
    }

    public OrdersProductsEntity update(UUID id, Map<String, String> fields) {

        OrdersProductsEntity orderProduct = repository.findById(id).orElse(null);
        if(orderProduct == null) {
            throw new IllegalStateException("OrderProduct with id = " + id + " not found.");
        }

        String note = fields.get(noteFieldName);
        if(note != null) {
            orderProduct.setNote(note);
        }

        String amount = fields.get(amountFieldName);
        if(amount != null) {
            orderProduct.setAmount(BigDecimal.valueOf(Long.valueOf(amount)));
        }

        return repository.save(orderProduct);
    }

    @Transactional
    public int deleteByProductId(UUID productId) {
        Collection<OrdersProductsEntity> ordersProducts = repository.findAllByProductId(productId);
        ordersProducts.forEach(
                x -> delete(x.getId()));
        return ordersProducts.size();
    }

    @Transactional
    public int deleteByOrderId(UUID orderId) {
        Collection<OrdersProductsEntity> ordersProducts = repository.findAllByOrderId(orderId);
        ordersProducts.forEach(
                x -> delete(x.getId()));
        return ordersProducts.size();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
