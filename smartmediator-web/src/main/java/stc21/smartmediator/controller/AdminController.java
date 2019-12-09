package stc21.smartmediator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String main(Map<String, Object> model) {

        return "admin/adminHome";
    }

    @GetMapping("/admin/orders")
    public String orders(Map<String, Object> model) {

        return "admin/adminOrders";
    }

    @GetMapping("/admin/bids")
    public String bids(Map<String, Object> model) {

        return "admin/adminBids";
    }

    @GetMapping("/admin/buyers")
    public String buyers(Map<String, Object> model) {

        return "admin/adminBuyers";
    }

    @GetMapping("/admin/sellers")
    public String sellers(Map<String, Object> model) {

        return "admin/adminSellers";
    }

}
