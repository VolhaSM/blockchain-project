package blockchain.project.Controller;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TrxListByWalletController {


    @Autowired
    BlockTransactionService service;

    @GetMapping("/{walletId}/transaction-list")
    public ModelAndView transactionList(
            @PathVariable String walletId,
            ModelAndView modelAndView) {

        List<BlockTransactions> transactions = service.findAllTransactionsByWalletId(walletId);
        modelAndView.setViewName("transaction-list");
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }
}
