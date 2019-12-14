package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('BUYER')")
public class BuyerController {

    @GetMapping("/buyer")
    public String main(Map<String, Object> model) {

        return "buyer/buyerhome";
    }

    @GetMapping("/buyer/orders")
    public String orders(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "buyer/buyerorders";
    }

    @GetMapping("/buyer/requests")
    public String requests(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "buyer/buyerrequests";
    }
    @GetMapping("/buyer/history")
    public String history(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "buyer/buyerhistory";
    }

    @GetMapping("/buyer/data")
    public String data(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "buyer/buyerdata";
    }




}
