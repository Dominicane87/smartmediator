package stc21.smartmediator.DTO;

import java.util.ArrayList;
import java.util.List;

public class ListOfSellers {
    List<String> sellers;

    public ListOfSellers(List<String> sellers) {
        this.sellers = sellers;
    }

    public ListOfSellers() {
        sellers=new ArrayList<>();
    }

    public List<String> getSellers() {
        return sellers;
    }

    public void setSellers(List<String> sellers) {
        this.sellers = sellers;
    }
}
