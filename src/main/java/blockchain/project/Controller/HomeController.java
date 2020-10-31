package blockchain.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home.html")
    public ModelAndView homepage (ModelAndView modelAndView) {

        modelAndView.addObject("greeting", "Hello blockchain User");
        modelAndView.setViewName("home");
        return modelAndView;


    }
}
