package stc21.smartmediator.DTO;

public class SellerOrder {
    String numberOfOrder;
    String date;
    String buyer;
    String address;
    Double sum;
    String status;

    public SellerOrder(String numberOfOrder, String date, String buyer, String address,  Double sum, String status) {
        this.numberOfOrder = numberOfOrder;
        this.buyer = buyer;
        this.address = address;
        this.sum = sum;
        this.date = date;
        this.status = status;
    }

    public SellerOrder() {
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(String numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
