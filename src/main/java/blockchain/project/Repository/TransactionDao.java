package blockchain.project.Repository;

import java.util.List;

public interface TransactionDao<T> {


    void create(T t);

    List<T> findAll(String searchStr);

    List<T> findAllByWalletId(String searchStr);

    List<T> findAllSendTx(String searchStr);

    List<T> findAllReceivedTx(String searchStr);
}
