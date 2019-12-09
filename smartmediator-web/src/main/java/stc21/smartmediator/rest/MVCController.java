package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import stc21.smartmediator.model.entity.User;
import stc21.smartmediator.model.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@Transactional
public class MVCController {

    private UserRepository userRepository;

    @Autowired
    public MVCController(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    @RequestMapping(value = "/")
    public ModelAndView root() {
        Map<String, Object> model = new HashMap<>();

        model.put("message", "HelloVladimir!!!");
        return new ModelAndView("RegistrationForm", model);
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(@ModelAttribute("login") String string) {
        Map<String, Object> model = new HashMap<>();

        model.put("message", string);
        return new ModelAndView("home", model);
    }


    @RequestMapping(value = "/{id}")
    public ModelAndView userById(@PathVariable("id") Integer id) {
        try {
            final Optional<User> user = userRepository.findById(id);
            Map<String, Object> model = new HashMap<>();
            model.put("message", String.format("Hello %s!!!", user.orElseThrow(() -> new RuntimeException("User not found!!!")).getFullName()));
            return new ModelAndView("home", model);
        } catch (Exception e) {
            return new ModelAndView("error", new HashMap<String, Object>() {{
                put("message", e.getMessage());
            }});
        }
    }

    @RequestMapping(path = "/error")
    public String error() {
        return "error";
    }
}
