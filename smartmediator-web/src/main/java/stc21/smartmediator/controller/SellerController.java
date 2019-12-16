package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import stc21.smartmediator.DTO.*;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.*;

@Controller
@PreAuthorize("hasAuthority('SELLER')")
public class SellerController {

    @GetMapping("/seller")
    public String main(Map<String, Object> model) {

        return "seller/sellerhome";
    }

    @GetMapping("/seller/products")
    public String products(Model model) {
        List<Product> products=new ArrayList<>();
        Product product = new Product();
        product.setName("Apple");
        product.setAmount(10);
        product.setPrice(Arrays.asList(new Double[]{1.0, 2.0}));
        product.setType(Arrays.asList(new String[]{"Magnit", "Baxetle"}));
        products.add(product);
        model.addAttribute("products",products);
        return "seller/sellerproducts";
    }

    @GetMapping("/seller/orders")
    public String orders(Model model) {
        List<SellerOrder> sellerOrders=new ArrayList<>();
        SellerOrder sellerOrder = new SellerOrder("123", "24.12.2015", "Vasya", "Mosckow", 200.0, "sended");
        sellerOrders.add(sellerOrder);
        model.addAttribute("sellerOrders",sellerOrders);
        return "seller/sellerorders";
    }
    @GetMapping("/seller/listOfOrders")
    public String selectedOrders(@ModelAttribute("HistoryDates") HistoryDates paramsOfOrder, Model model) {

        System.out.println(paramsOfOrder.getDateFrom()+" "+paramsOfOrder.getDateTo());
        //Послать запрос на поиск заказов

        List<SellerOrder> sellerOrders=new ArrayList<>();
        SellerOrder sellerOrder = new SellerOrder("123", "24.12.2015", "Vasya", "Mosckow", 200.0, "sended");
        sellerOrders.add(sellerOrder);
        sellerOrders.add(sellerOrder);
        model.addAttribute("sellerOrders",sellerOrders);
        return "seller/sellerorders";
    }

    @GetMapping("/seller/buyers")
    public String buyers(Map<String, Object> model) {
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
        return "seller/sellerbuyers";
    }

    @GetMapping("/seller/data")
    public String data(Model model) {
        BuyerData buyerData = new BuyerData("Vasya", "123", new String[]{"dsf", "dsf"});
        //ПОлучить данные пользователя
        model.addAttribute("buyerData",buyerData);
        return "seller/sellerdata";
    }
    @GetMapping("/buyer/saveDataUser")
    public String saveData(@ModelAttribute("buyerData") BuyerData buyerData) {
        System.out.println(buyerData);
        //Сохранить данные
        return "redirect:/seller/data";
    }



}
