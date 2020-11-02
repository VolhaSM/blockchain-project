package blockchain.project.repository;

import blockchain.project.pojo.Wallet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("walletRepo")

public class WalletRepo implements GenericDao<Wallet> {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    @Transactional
    public void create(Wallet wallet) {

        sessionFactory.getCurrentSession()
                .saveOrUpdate(wallet);

    }


    @Override
    @Transactional(readOnly = true)
    public Wallet find(String searchStr) {

        return sessionFactory
                .getCurrentSession()
                .createQuery("from Wallet w where w.id like :searchStr", Wallet.class)
                .setParameter("searchStr", "%" + searchStr + "%")
                .list()
                .stream()
                .findFirst()
                .orElse(null);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Wallet> findAll(String userId) {

        return sessionFactory.
                getCurrentSession()
                .createQuery("from Wallet r where r.userId like :userId", Wallet.class)
                .setParameter("userId", "%" + userId + "%")
                .list();
    }


}
