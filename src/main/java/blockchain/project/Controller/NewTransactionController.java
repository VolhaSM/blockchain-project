package blockchain.project.Controller;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/new-transaction.html")
public class NewTransactionController {

    @Autowired
    BlockTransactionService blockTransactionService;

    @GetMapping
    public String showTransactions(){

        return "new-transaction";
    }

    @PostMapping
    public String createTransaction(
            @ModelAttribute BlockTransactions transaction,
            Model model
    ) {

        System.out.println("New transaction " + transaction);

        if (blockTransactionService.createNewTransaction(transaction.getSender(), transaction.getRecipient(), transaction)) {

            return "redirect:home.html";
        } else {
            model.addAttribute("errorMessage", "Cannot create a new transaction");
            return "error-page";

        }
    }

}
