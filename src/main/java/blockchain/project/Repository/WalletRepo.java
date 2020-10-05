package blockchain.project.Repository;

import blockchain.project.Pojo.Wallet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@Repository("walletRepo")

public class WalletRepo implements GenericDao<Wallet> {

    @Autowired
    SessionFactory sessionFactory;


    public void createWallet(String userId, Wallet wallet) {

        wallet.setUserId(userId);
        sessionFactory.getCurrentSession()
                .saveOrUpdate(wallet);

    }

    @Override
    public void create(Wallet wallet) {

    }

    @Override
    public void update(Wallet wallet) {

    }

    @Override
    public Wallet read(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public void delete(Wallet wallet) {

    }

    @Override
    public Wallet find(String userId) {
        return null;
    }

    @Override
    public List<Wallet> findAll(String searchStr) {
        return null;
    }
}
