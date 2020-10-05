package blockchain.project.Controller;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Service.BlockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlockTransactionController {

    @Autowired
    private BlockTransactionService blockTransactionService;

    @PostMapping("/new-transaction")
    public BlockTransactions createNewTransaction(BlockTransactions transactions) {
        blockTransactionService.create(transactions);

        return null;
    }

    @GetMapping("/transactions/{id}")
    public List<BlockTransactions> getTransactionsById(@PathVariable String id) {

        return blockTransactionService.findAllTransactionsByUserId(id);

    }




}
