package blockchain.project.Controller;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

    @PostMapping
    public String registerNewUser(BlockchainUser user) {
        userService.createNewUser(user);
        return "redirect:home.html";

    }
}
