package blockchain.project.controller;

import blockchain.project.pojo.Wallet;
import blockchain.project.service.UserService;
import blockchain.project.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WalletListController {


    @Autowired
    WalletService walletService;

    @Autowired
    UserService userService;


    @GetMapping("/wallet-list.html")
    public ModelAndView allWalletList(ModelAndView modelAndView) {
        String userId = userService.findByUserName(UserService.getUsernameAuthUser()).getUserId();
        List<Wallet> wallets = walletService.getAllWallets(userId);

        modelAndView.setViewName("wallet-list");
        modelAndView.addObject("wallets", wallets);
        return modelAndView;
    }




}
