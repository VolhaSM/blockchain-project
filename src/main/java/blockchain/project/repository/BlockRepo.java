package blockchain.project.repository;

import blockchain.project.pojo.Block;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("blockRepo")
public class BlockRepo implements GenericDao<Block> {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Block block) {

    }

    @Override
    public Block find(String searchStr) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Block> findAll(String walletId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Block b where b.walletId like :walletId", Block.class)
                .setParameter("walletId", walletId)
                .list();
    }
}
