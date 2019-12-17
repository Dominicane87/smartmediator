package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import stc21.smartmediator.DTO.HistoryDates;
import stc21.smartmediator.DTO.Organisation;
import stc21.smartmediator.DTO.SellerOrder;
import stc21.smartmediator.entity.OrganizationsEntity;
import stc21.smartmediator.service.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping("/admin")
    public String main(Map<String, Object> model) {
        return "admin/adminHome";
    }

    @GetMapping("/admin/orders")
    public String orders(Model model) {
        List<SellerOrder> sellerOrders=new ArrayList<>();
        SellerOrder sellerOrder = new SellerOrder("123", "24.12.2015", "Vasya", "Mosckow", 200.0, "sended");
        sellerOrders.add(sellerOrder);
        //ПОлучить список заказов
        model.addAttribute("sellerOrders",sellerOrders);
        return "admin/adminorders";
    }

    @GetMapping("/admin/listOfOrders")
    public String selectedOrders(@ModelAttribute("HistoryDates") HistoryDates paramsOfOrder, Model model) {
        System.out.println(paramsOfOrder.getDateFrom()+" "+paramsOfOrder.getDateTo());
        //Послать запрос на поиск заказов и получить список заказов
        List<SellerOrder> sellerOrders=new ArrayList<>();
        SellerOrder sellerOrder = new SellerOrder("123", "24.12.2015", "Vasya", "Mosckow", 200.0, "sended");
        sellerOrders.add(sellerOrder);
        sellerOrders.add(sellerOrder);
        model.addAttribute("sellerOrders",sellerOrders);
        return "admin/adminorders";
    }

    @GetMapping("/admin/bids")
    public String bids(Map<String, Object> model) {
        List<Organisation> listOfOrganizations = new ArrayList<Organisation>();
        Organisation organisation = new Organisation();
        Organisation organisation1 = new Organisation();
        organisation.setFullName("Vasa");
        organisation.setAddress("Moscow");
        organisation1.setFullName("Vasa");
        organisation1.setAddress("Moscow");
        listOfOrganizations.add(organisation);
        listOfOrganizations.add(organisation1);
//Получить список заявок и добавить в модель
        model.put("listOfOrganizations",listOfOrganizations);
        return "admin/adminbids";
    }

    @GetMapping("/admin/buyers")
    public String buyers(Model model) {
        List<Organisation> listOfOrganizations = new ArrayList<>();
        Organisation organisation = new Organisation();
        Organisation organisation1 = new Organisation();
        organisation.setFullName("Vasa");
        organisation.setAddress("Moscow");
        organisation1.setFullName("Vasa");
        organisation1.setAddress("Moscow");
        organisation.setId(new UUID(23,23));
        organisation1.setId(new UUID(23,23));
        listOfOrganizations.add(organisation);
        listOfOrganizations.add(organisation1);
        //ПОлучить список покупателей и заполнить в модель
        model.addAttribute("listOfOrganizations",listOfOrganizations);
        return "admin/adminbuyers";
    }

    @GetMapping("/admin/buyers/formCreateBuyer")
    public String formCreateUser(Model model) {
        return "admin/admincreatebuyer";
    }

    @GetMapping("/admin/buyers/createUser")
    public String createBuyer(@ModelAttribute("Organisation") Organisation organisation1) {
        String name=organisation1.getFullName();
        //Создать организацию и сохранить в базу
        return "redirect:/admin/buyers";
    }

    @GetMapping("/admin/buyers/{id}")
    public String buyersEdit(@PathVariable String id, Model model) {
        Organisation organisation = new Organisation();
        //Получить организацию по ID и добавить в модель
        organisation.setId(new UUID(23,23));
        organisation.setFullName("Vladimir");
        organisation.setAddress("ASdf");
        organisation.setType("Покупатель");
        model.addAttribute("organisation",organisation);
        return "admin/admineditbuyer";
    }

    @GetMapping("/admin/buyers/saveUser/{id}")
    public String saveBuyer(@PathVariable String id, @ModelAttribute("Organisation") Organisation organizationsEntity) {
        String name=organizationsEntity.getFullName();
        //Сохранить организацию по ID в базу
        return "redirect:/admin/buyers";
    }

    @GetMapping("/admin/buyers/deleteUser/{id}")
    public String deleteBuyer(@PathVariable UUID id, @ModelAttribute("Organisation") Organisation organizationsEntity) {
        String idN=id.toString();
        //Удалить организацию
        return "redirect:/admin/buyers";
    }


    @GetMapping("/admin/sellers")
    public String sellers(Model model) {
        List<Organisation> listOfOrganizations = new ArrayList<>();
        Organisation organisation = new Organisation();
        Organisation organisation1 = new Organisation();
        organisation.setFullName("Vasa");
        organisation.setAddress("Moscow");
        organisation1.setFullName("Vasa");
        organisation1.setAddress("Moscow");
        organisation.setId(new UUID(23,23));
        organisation1.setId(new UUID(23,23));
        listOfOrganizations.add(organisation);
        listOfOrganizations.add(organisation1);
        //ПОлучить список покупателей и заполнить в модель
        model.addAttribute("listOfOrganizations",listOfOrganizations);
        return "admin/adminsellers";
    }

    @GetMapping("/admin/sellers/formCreateSeller")
    public String formCreateSeller(Model model) {
        return "admin/admincreateseller";
    }

    @GetMapping("/admin/sellers/createUser")
    public String createSeller(@ModelAttribute("Organisation") Organisation organisation1) {
        String name=organisation1.getFullName();
        //Создать организацию и сохранить в базу
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/{id}")
    public String sellersEdit(@PathVariable String id, Model model) {
        Organisation organisation = new Organisation();
        //Получить организацию по ID и добавить в модель
        organisation.setId(new UUID(23,23));
        organisation.setFullName("Vladimir");
        organisation.setAddress("ASdf");
        organisation.setType("Покупатель");
        model.addAttribute("organisation",organisation);
        return "admin/admineditseller";
    }

    @GetMapping("/admin/sellers/saveUser/{id}")
    public String saveSeller(@PathVariable String id, @ModelAttribute("Organisation") Organisation organizationsEntity) {
        String name=organizationsEntity.getFullName();
        //Сохранить организацию по ID в базу
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/deleteUser/{id}")
    public String deleteSeller(@PathVariable UUID id, @ModelAttribute("Organisation") Organisation organizationsEntity) {
        String idN=id.toString();
        //Удалить организацию
        return "redirect:/admin/sellers";
    }

}
