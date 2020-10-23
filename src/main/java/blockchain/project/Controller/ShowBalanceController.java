package blockchain.project.Controller;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Service.BlockTransactionService;
import blockchain.project.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ShowBalanceController {

    @Autowired
    BlockTransactionService blockTransactionService;


    @GetMapping("/{walletId}/balance.html")
    public ModelAndView showBalance(ModelAndView modelAndView,
                                    @PathVariable String walletId) {
        Double balance = blockTransactionService.findBalance(walletId);

        modelAndView.setViewName("balance");
        modelAndView.addObject("balance", balance);
        return modelAndView;


    }




}
