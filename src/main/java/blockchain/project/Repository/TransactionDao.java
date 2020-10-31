package blockchain.project.Repository;

import java.io.Serializable;
import java.util.List;

public interface TransactionDao <T> {


    void create(T t);
    void update(T t);
    T read(Class clazz, Serializable id);
    void delete(T t);

    public T find(String userId);

    List<T> findAll(String searchStr);

    List<T> findAllByWalletId(String searchStr);

    List<T> findAllSendTx(String searchStr);
    List<T> findAllReceivedTx(String searchStr);
}
