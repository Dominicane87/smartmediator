package stc21.smartmediator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WorkController {

    @GetMapping("/orders")
    public String orders(Map<String, Object> model) {

        return "orders";
    }

    @GetMapping("/bids")
    public String bids(Map<String, Object> model) {

        return "bids";
    }

    @GetMapping("/history")
    public String history(Map<String, Object> model) {

        return "history";
    }

    @GetMapping("/data")
    public String data(Map<String, Object> model) {

        return "data";
    }

}
