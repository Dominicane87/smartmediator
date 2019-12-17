package stc21.smartmediator.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListOfOrders {
    List<Order> orders;

    public ListOfOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ListOfOrders() {
        orders =new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
