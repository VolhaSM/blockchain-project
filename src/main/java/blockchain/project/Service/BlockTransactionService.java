package blockchain.project.Service;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Pojo.Wallet;
import blockchain.project.Repository.BlockTransactionRepo;
import blockchain.project.Repository.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockTransactionService {

    @Autowired
    @Value("#{blockTransactionRepo}")
    GenericDao<BlockTransactions>  blockTransactionRepo;

    private static final Logger Log = LoggerFactory.getLogger(BlockTransactionService.class);


    public boolean createNewTransaction(String sender, String recipient, BlockTransactions transaction) {

        Log.info("Save a new Transaction with wallet id,  recipient and sender: {}, {}, {}",
                transaction.getId(),transaction.getRecipient(), transaction.getSender()
        );

        if(blockTransactionRepo.find(transaction.getSender())!= null) {
            return false;}

        blockTransactionRepo.create(transaction);
        transaction.setRecipient(recipient);
        transaction.setSender(sender);
        return true;
    }

    public List<BlockTransactions> findAllTransactionsByUserId(String id) {

        return null;
    }
}
