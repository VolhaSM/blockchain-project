package blockchain.project.Repository;

import blockchain.project.Pojo.BlockTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockTransactionRepository extends CrudRepository <BlockTransactions, String> {
}
