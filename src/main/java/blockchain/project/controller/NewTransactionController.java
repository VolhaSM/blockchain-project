package blockchain.project.controller;

import blockchain.project.pojo.BlockTransactions;
import blockchain.project.service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/{walletId}/new-transaction.html")
public class NewTransactionController {

    @Autowired
    BlockTransactionService blockTransactionService;

    @GetMapping
    public String showTransactions(
            ModelAndView modelAndView,
            @PathVariable String walletId){
        modelAndView.addObject("walletId", walletId);


        return "new-transaction";
    }

    @PostMapping
    public String createTransaction(
            @PathVariable String walletId,
            @ModelAttribute BlockTransactions transaction,
            Model model
    ) {

        if (blockTransactionService.createNewTransaction(walletId,  transaction)) {

            return "redirect: transaction-list";
        } else {
            model.addAttribute("errorMessage", "Cannot create a new transaction");
            return "error-page";

        }
    }

}
