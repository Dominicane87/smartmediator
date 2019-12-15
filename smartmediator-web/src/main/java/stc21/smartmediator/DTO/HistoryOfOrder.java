package stc21.smartmediator.DTO;

public class HistoryOfOrder {
    String numberOfOrder;
    String seller;
    String address;
    Double sum;
    String date;
    String status;

    public HistoryOfOrder(String numberOfOrder, String seller, String address, String date,Double sum,  String status) {
        this.numberOfOrder = numberOfOrder;
        this.seller = seller;
        this.address = address;
        this.sum = sum;
        this.date = date;
        this.status = status;
    }

    public HistoryOfOrder() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
