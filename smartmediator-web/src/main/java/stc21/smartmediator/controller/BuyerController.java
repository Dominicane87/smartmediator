package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import stc21.smartmediator.DTO.HistoryDates;
import stc21.smartmediator.DTO.HistoryOfOrder;
import stc21.smartmediator.DTO.Order;
import stc21.smartmediator.DTO.ParamsOfOrder;
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
        Order grass = new Order("Grass", 3.5, 5, 10);
        List<Order> listOfOrders=new ArrayList<Order>();
        model.put("listOfOrders",listOfOrders);
        return "buyer/buyerorders";
    }

    @GetMapping("/buyer/takeDataOfOrder")
    public String renewOrders(@ModelAttribute("ParamsOfOrder") ParamsOfOrder paramsOfOrder, Model model) {
        Order grass = new Order("Grass", 3.5, 5, 10);
        List<Order> listOfOrders=new ArrayList<Order>(){{
            add(grass);
            add(grass);
            add(grass);
        }};

        System.out.println(paramsOfOrder.getSeller()+" "+paramsOfOrder.getAddress()+" "+paramsOfOrder.getDate());
        //Получить список заказов
//ДОбавить список по фильтрам
        model.addAttribute("listOfOrders",listOfOrders);
        return "buyer/buyerorders";
    }




    @GetMapping("/buyer/requests")
    public String requests(Map<String, Object> model) {
        //ДОбавить список по фильтрам
        return "buyer/buyerrequests";
    }

    @GetMapping("/buyer/sendRequest")
    public String makeRequest(@ModelAttribute("ParamsOfOrder") ParamsOfOrder paramsOfOrder) {

        System.out.println(paramsOfOrder.getSeller()+" "+paramsOfOrder.getAddress());
        //Послать запрос продавцу

        return "buyer/buyerrequests";
    }


    @GetMapping("/buyer/history")
    public String history(Model model) {
        List<HistoryOfOrder> listOfOrdersHistory = new ArrayList<HistoryOfOrder>(){
            {
                add(new HistoryOfOrder("123","Vasya","L","23/12/23",234.0,"sended"));
                add(new HistoryOfOrder("124","Vasya","L","23/12/23",234.0,"sended"));
            }
        };

        model.addAttribute("listOfOrdersHistory",listOfOrdersHistory);
        return "buyer/buyerhistory";
    }

    @GetMapping("/buyer/historyOfOrders")
    public String selectedHistory(@ModelAttribute("HistoryDates") HistoryDates paramsOfOrder, Model model) {

        System.out.println(paramsOfOrder.getDateFrom()+" "+paramsOfOrder.getDateTo());
        //Послать запрос продавцу

        List<HistoryOfOrder> listOfOrdersHistory = new ArrayList<HistoryOfOrder>(){
            {
                add(new HistoryOfOrder("123","Vasya","L","23/12/23",234.0,"sended"));
                add(new HistoryOfOrder("124","Vasya","L","23/12/23",234.0,"sended"));
                add(new HistoryOfOrder("127","Vasya","L","23/12/23",234.0,"sended"));
            }
        };
        model.addAttribute("listOfOrdersHistory",listOfOrdersHistory);
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
