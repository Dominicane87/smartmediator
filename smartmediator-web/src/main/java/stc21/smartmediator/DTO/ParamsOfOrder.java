package stc21.smartmediator.DTO;

import java.util.Date;

public class ParamsOfOrder {
    String seller;
    String address;
    String date;

    public ParamsOfOrder() {
    }

    public ParamsOfOrder(String seller, String address, String date) {
        this.seller = seller;
        this.address = address;
        this.date = date;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
