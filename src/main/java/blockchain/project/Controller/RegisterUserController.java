package blockchain.project.Controller;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ModelAndView showRegisterPage() {

        return new ModelAndView("register");
    }


    @PostMapping
    public String registerNewUser(@ModelAttribute BlockchainUser user,
                                  Model model) {
        if(userService.createNewUser(user)) {
            return "redirect:home.html";
        }
        else {
            model.addAttribute("errorMessage", "Cannot create a new user, it already exists");
            return "error-page";
        }


    }
}
