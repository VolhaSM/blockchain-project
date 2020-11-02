package blockchain.project.controller;

import blockchain.project.pojo.BlockTransactions;
import blockchain.project.service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrxListController {

    @Autowired
    BlockTransactionService service;

   @GetMapping("/all-transactions-list")
    public ModelAndView transactionList(
            ModelAndView modelAndView) {

        List<BlockTransactions> transactions = service.findAllTransactions("");
        modelAndView.setViewName("all-transactions-list");
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }
}
