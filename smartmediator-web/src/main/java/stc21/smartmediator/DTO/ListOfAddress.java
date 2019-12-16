package stc21.smartmediator.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfAddress {
    List<String> addresses;

    public ListOfAddress() {
        addresses= new ArrayList<>();
    }

    public ListOfAddress(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
