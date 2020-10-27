package blockchain.project.Controller;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionListController {

    @Autowired
    BlockTransactionService service;

    @GetMapping("/transaction-list")
    public ModelAndView transactionList(
            ModelAndView modelAndView) {


        List<BlockTransactions> transactions = service.findAllTransactionsByWalletId("");

        modelAndView.setViewName("transaction-list");
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }
}
