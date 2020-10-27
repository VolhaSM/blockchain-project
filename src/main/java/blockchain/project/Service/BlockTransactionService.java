package blockchain.project.Service;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Pojo.Wallet;
import blockchain.project.Repository.BlockTransactionRepo;
import blockchain.project.Repository.GenericDao;
import blockchain.project.Repository.TransactionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockTransactionService {

    @Autowired
    @Value("#{blockTransactionRepo}")
    TransactionDao<BlockTransactions> blockTransactionRepo;

    private static final Logger Log = LoggerFactory.getLogger(BlockTransactionService.class);


    public boolean createNewTransaction(String sender, String recipient, BlockTransactions transaction) {

        Log.info("Save a new Transaction with wallet id,  recipient and sender: {}, {}, {}",
                transaction.getId(),transaction.getRecipient(), transaction.getSender()
        );

        if(blockTransactionRepo.find(transaction.getSender())!= null) {
            return false;}


        transaction.setRecipient(recipient);
        transaction.setSender(sender);
        transaction.setTxStatus("in progress");
        blockTransactionRepo.create(transaction);

        return true;
    }
    public String createGenesisTransaction(String recipient, double value) {

        BlockTransactions genesisTx = new BlockTransactions();
        genesisTx.setRecipient(recipient);
        genesisTx.setValue(value);
        genesisTx.setTxStatus("in progress");
        blockTransactionRepo.create(genesisTx);

        return "transaction is created";


    }

    public List<BlockTransactions> findAllTransactionsByWalletId(String searchStr) {

//        List <BlockTransactions> transactions = blockTransactionRepo.findAllSendTx(searchStr)
//        return transactions
    }

    public double findBalance(String walletId) {
        List<BlockTransactions> sendTransactions = blockTransactionRepo.findAllSendTx(walletId);

        Log.info("Transaction send {}", sendTransactions);
        List<BlockTransactions> receivedTransactions = blockTransactionRepo.findAllReceivedTx(walletId);

        Log.info("Transaction received {}", receivedTransactions);


        ArrayList<Double> valuesOfSend = new ArrayList<>();

        for (BlockTransactions tr : sendTransactions
        ) {
            valuesOfSend.add(tr.getValue());
        }

        double sumSend = 0;
        for (Double v : valuesOfSend
        ) {
            sumSend = sumSend + v;
        }

        Log.info("Sum send = {}", sumSend);

        ArrayList<Double> valuesOfReceived = new ArrayList<>();

        for (BlockTransactions tr : receivedTransactions
        ) {
            valuesOfReceived.add(tr.getValue());
        }

        double sumReceived = 0;
        for (Double v : valuesOfReceived
        ) {
            sumReceived = sumReceived + v;
        }

        Log.info("Sum received = {}", sumReceived);

        return  sumReceived - sumSend;

    }





}
