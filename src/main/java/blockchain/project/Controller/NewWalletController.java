package blockchain.project.Controller;

import blockchain.project.Pojo.Wallet;
import blockchain.project.Service.UserService;
import blockchain.project.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/new-wallet.html")
public class NewWalletController {

    @Autowired
    WalletService walletService;

    @Autowired
    UserService userService;

    @GetMapping
    public String showWallet() {

        return "new-wallet";
    }


    @PostMapping
    public String createNewWallet(
            @ModelAttribute Wallet wallet,
            Model model
    ) {

        String ownerId = userService.findByUserName(UserService.getUsernameAuthUser()).getUserId();

        System.out.println("New wallet " + wallet);
        if (walletService.createNewWallet(wallet, ownerId)) {
            return "redirect:home.html";
        } else {
            model.addAttribute("errorMessage", "Cannot create a new wallet");
            return "error-page";
        }

    }
}
