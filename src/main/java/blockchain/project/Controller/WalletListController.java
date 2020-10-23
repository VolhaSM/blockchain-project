package blockchain.project.Controller;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Pojo.Wallet;
import blockchain.project.Service.UserService;
import blockchain.project.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
