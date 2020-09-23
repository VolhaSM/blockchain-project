package blockchain.project.Repository;

import blockchain.project.Pojo.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends CrudRepository <Wallet, String> {
}
