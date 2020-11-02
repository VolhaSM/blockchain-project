package blockchain.project.service;

import blockchain.project.pojo.BlockTransactions;
import blockchain.project.pojo.Wallet;
import blockchain.project.repository.GenericDao;
import blockchain.project.repository.TransactionDao;
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

    @Autowired
    @Value("#{walletRepo}")
    GenericDao<Wallet> walletRepo;


    private static final Logger Log = LoggerFactory.getLogger(BlockTransactionService.class);


    public boolean createNewTransaction(String walletId, BlockTransactions transaction) {

        Log.info("Save a new Transaction with wallet id, recipient and sender: {}, {}",
                transaction.getId(), transaction.getSender()
        );

        Wallet wallet = walletRepo.find(
                walletId);

        Log.info("wallet we found {}", wallet);
        String pKey = wallet.getPrivateKey();

        //найти прайвет ки из валлета, проверить, совпадает ли введенный в ранзакцию пр ки с ним
        // проверить если суииа баланса меньше суммы транзакции
        if (findBalance(walletId) > transaction.getValue()
                && pKey.equals(transaction.getPrivateKey())) {
            Log.info("wallet id is {} and tx value is {}", findBalance(walletId), transaction.getValue());

            transaction.setSender(walletId);
            transaction.setStatus("inProgress");

            blockTransactionRepo.create(transaction);

            return true;

        }

        return false;
    }


    public String createGenesisTransaction(String recipient, double value) {

        BlockTransactions genesisTx = new BlockTransactions();
        genesisTx.setRecipient(recipient);
        genesisTx.setValue(value);
        genesisTx.setStatus("inProgress");
        blockTransactionRepo.create(genesisTx);

        return "transaction is created";


    }

    public List<BlockTransactions> findAllTransactions(String searchStr) {

        return blockTransactionRepo.findAll(searchStr);
    }

    public List<BlockTransactions> findAllTransactionsByWalletId(String searchStr) {

        return blockTransactionRepo.findAllByWalletId(searchStr);
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

        return sumReceived - sumSend;

    }

}
