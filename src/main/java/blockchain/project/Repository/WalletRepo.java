package blockchain.project.Repository;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Pojo.Wallet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
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
    public void update(Wallet wallet) {

    }



    @Override
    public Wallet read(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public void delete(Wallet wallet) {

    }

    @Transactional
    @Override
    public Wallet find(String walletId) {

        return null;


//        return  sessionFactory
//                .getCurrentSession()
//                .createQuery("from Wallet w where w.id=walletId", Wallet.class)
//                .setParameter("walletId", walletId)
//                .list()
//                .stream()
//                .findFirst()
//                .orElse(null);
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
