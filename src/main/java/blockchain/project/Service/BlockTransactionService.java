package blockchain.project.Service;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Repository.BlockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockTransactionService {

    @Autowired
    BlockTransactionRepo blockTransactionRepo;



    public List<BlockTransactions> findAllTransactionsByUserId(String id) {

        return null;
    }


    public void create(BlockTransactions transactions) {
        blockTransactionRepo.create(transactions);

    }
}
