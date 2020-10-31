package blockchain.project.Repository;

import blockchain.project.Pojo.BlockTransactions;
import blockchain.project.Pojo.Wallet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("blockTransactionRepo")

public class BlockTransactionRepo implements TransactionDao<BlockTransactions> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(BlockTransactions blockTransactions) {

        sessionFactory.getCurrentSession()
                .saveOrUpdate(blockTransactions);

    }

    @Override
    public void update(BlockTransactions blockTransactions) {

    }

    @Override
    public BlockTransactions read(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public void delete(BlockTransactions blockTransactions) {

    }

    @Override
    public BlockTransactions find(String searchStr) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public List<BlockTransactions> findAll(String searchStr) {

        return sessionFactory
                .getCurrentSession()
                .createQuery("from BlockTransactions b where b.recipient like :searchStr", BlockTransactions.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list();


    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockTransactions> findAllByWalletId(String searchStr) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from BlockTransactions b where b.recipient like :searchStr OR b.sender like :searchStr", BlockTransactions.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list();


    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockTransactions> findAllSendTx(String searchStr) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from BlockTransactions b where b.sender like :searchStr", BlockTransactions.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list();

    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockTransactions> findAllReceivedTx(String searchStr) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from BlockTransactions b where b.recipient like :searchStr", BlockTransactions.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list();

    }
}
