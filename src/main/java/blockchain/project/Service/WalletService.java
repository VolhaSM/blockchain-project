package blockchain.project.Service;

import blockchain.project.Pojo.Wallet;
import blockchain.project.Repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    WalletRepo walletRepo;

    public List<Wallet> getAllWallets(String id) {
        return walletRepo.findAll(id);

    }

    public Wallet findWallet(String userId) {
        return walletRepo.find(userId);
    }

    public void createNewWallet(String id, Wallet wallet) {

         walletRepo.createWallet(id, wallet);
    }
}
