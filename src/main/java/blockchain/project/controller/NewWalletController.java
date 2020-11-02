package blockchain.project.controller;

import blockchain.project.pojo.Wallet;
import blockchain.project.service.BlockTransactionService;
import blockchain.project.service.UserService;
import blockchain.project.service.WalletService;
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

    @Autowired
    BlockTransactionService blockTransactionService;

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

        //когда создается новый кошелек, создается первая транзакция, которая закидывает деньги
        if (walletService.createNewWallet(wallet, ownerId)) {
            blockTransactionService.createGenesisTransaction(wallet.getId(), 500);

            return "redirect:home.html";
        } else {
            model.addAttribute("errorMessage", "Cannot create a new wallet");
            return "error-page";
        }

    }
}
