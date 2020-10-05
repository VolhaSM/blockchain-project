package blockchain.project.Repository;

import blockchain.project.Pojo.BlockTransactions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("blockTransactionRepo")

public class BlockTransactionRepo implements GenericDao <BlockTransactions> {
    @Override
    public void create(BlockTransactions blockTransactions) {

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
    public BlockTransactions find(String userId) {
        return null;
    }

    @Override
    public List<BlockTransactions> findAll(String searchStr) {
        return null;
    }
}
