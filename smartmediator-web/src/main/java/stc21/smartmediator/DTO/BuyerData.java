package stc21.smartmediator.DTO;

import java.util.List;

public class BuyerData {
    String nameOfOrganisation;
    String inn;
    String[] address;

    public BuyerData() {
    }

    public BuyerData(String nameOfOrganisation, String inn, String[] address) {
        this.nameOfOrganisation = nameOfOrganisation;
        this.inn = inn;
        this.address=address;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public void setNameOfOrganisation(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BuyerData{" +
                "nameOfOrganisation='" + nameOfOrganisation + '\'' +
                ", inn='" + inn + '\'' +
                ", address=" + address +
                '}';
    }
}
