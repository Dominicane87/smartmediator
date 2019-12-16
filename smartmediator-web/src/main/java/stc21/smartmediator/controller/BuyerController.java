package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import stc21.smartmediator.DTO.*;

import java.util.*;

@Controller
@PreAuthorize("hasAuthority('BUYER')")
public class BuyerController {
    BuyerData mybuyerData=null;

    @GetMapping("/buyer")
    public String main(Map<String, Object> model) {

        return "buyer/buyerhome";
    }

    @GetMapping("/buyer/orders")
    public String orders(Model model) {
        Order grass = new Order("Grass", 3.5, 5, 10);
        List<Order> listOfOrders=new ArrayList<Order>();
        model.addAttribute("listOfOrders",listOfOrders);
        //Получить список поставщиков
        //Получить список адресов
        ListOfAddress listOfAddress = new ListOfAddress();
        listOfAddress.getAddresses().add("Moskau");
        listOfAddress.getAddresses().add("Moskau");
        ListOfSellers listOfSellers = new ListOfSellers();
        listOfSellers.getSellers().add("Vasia");
        listOfSellers.getSellers().add("Vova");
        model.addAttribute("addresses", listOfAddress);
        model.addAttribute("sellers", listOfSellers);


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
    public String requests(Model model) {
        ListOfAddress listOfAddress = new ListOfAddress();
        listOfAddress.getAddresses().add("Moskau");
        listOfAddress.getAddresses().add("Moskau");
        ListOfSellers listOfSellers = new ListOfSellers();
        listOfSellers.getSellers().add("Vasia");
        listOfSellers.getSellers().add("Vova");
        model.addAttribute("addresses", listOfAddress);
        model.addAttribute("sellers", listOfSellers);
        //Получить список поставщиков для фильтра
        //Получить список адресов
        //Получить список действующих поставщиков
        ListOfSellers actualListOfSellers = new ListOfSellers();
        actualListOfSellers.getSellers().add("Vasia");
        actualListOfSellers.getSellers().add("Vova");
        actualListOfSellers.getSellers().add("Maks");

        model.addAttribute("actualSellers",actualListOfSellers);
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
    public String data(Model model) {
        BuyerData buyerData = new BuyerData("Vasilek", "123", Arrays.asList(new String[]{"qwe", "qrwe"}));
        model.addAttribute("buyerData",buyerData);
        return "buyer/buyerdata";
    }

    @GetMapping("/buyer/saveData")
    public String saveData(@ModelAttribute("BuyerData") BuyerData buyerData) {
        System.out.println(buyerData);
        //Сохранить данные покупателя
        return "buyer/buyerdata";
    }

    @GetMapping("/buyer/changePassword")
    public String changePassword() {

        return "buyer/buyerChangePassword";
    }
    @GetMapping("/buyer/savePassword")
    public String saveData(@ModelAttribute("Password") Password password) {

        if (password.getPassword().equals(password.getPasswordRepeat())){
            //Сохранить пароль
            return "redirect:/buyer/data";
        } else {
            return "buyer/buyerChangePassword";
        }
    }


}
