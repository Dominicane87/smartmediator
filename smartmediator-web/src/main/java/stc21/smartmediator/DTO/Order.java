package stc21.smartmediator.DTO;

public class Order {
    String name;
    Double price;
    Integer amount;
    Integer maxAmount;

    public Order(String name, Double price, Integer amount, Integer maxAmount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.maxAmount = maxAmount;
    }

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }
}
