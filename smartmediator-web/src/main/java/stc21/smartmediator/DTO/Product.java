package stc21.smartmediator.DTO;

import java.util.ArrayList;
import java.util.List;

public class Product {
    String name;
    List<String> type;
    List<Double> price;
    Integer amount;

    public Product() {
        type=new ArrayList<>();
        price=new ArrayList<>();
    }

    public Product(String name, List<String> type, List<Double> price, Integer amount) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<Double> getPrice() {
        return price;
    }

    public void setPrice(List<Double> price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
