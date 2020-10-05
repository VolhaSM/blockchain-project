package blockchain.project.Repository;

import blockchain.project.Pojo.BlockchainUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@Repository("userRepo")

public class UserRepo implements GenericDao <BlockchainUser> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(BlockchainUser user) {

        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(user);

    }

    @Override
    public void update(BlockchainUser blockchainUser) {

    }

    @Override
    public BlockchainUser read(Class clazz, Serializable id) {
        return sessionFactory
                .getCurrentSession()
                .get(BlockchainUser.class, id);
    }

    @Override
    public void delete(BlockchainUser blockchainUser) {

    }

    @Override
    public BlockchainUser find(String userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from BlockchainUser u where u.userName=:username", BlockchainUser.class)
                .setParameter("username", userId)
                .list()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BlockchainUser> findAll(String searchStr) {
        return null;
    }
}
