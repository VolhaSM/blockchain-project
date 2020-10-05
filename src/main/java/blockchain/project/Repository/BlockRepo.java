package blockchain.project.Repository;

import blockchain.project.Pojo.Block;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("blockRepo")
public class BlockRepo implements GenericDao<Block> {
    @Override
    public void create(Block block) {

    }

    @Override
    public void update(Block block) {

    }

    @Override
    public Block read(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public void delete(Block block) {

    }

    @Override
    public Block find(String userId) {
        return null;
    }

    @Override
    public List<Block> findAll(String searchStr) {
        return null;
    }
}
