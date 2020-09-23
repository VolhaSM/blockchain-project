package blockchain.project.Repository;

import blockchain.project.Pojo.Block;
import blockchain.project.Pojo.BlockchainUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepo extends GenericDao<Block> {

}
