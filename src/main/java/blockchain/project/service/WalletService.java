package blockchain.project.service;

import blockchain.project.pojo.Wallet;
import blockchain.project.repository.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {


    @Autowired
    @Value("#{walletRepo}")
    GenericDao<Wallet> walletRepo;


    private static final Logger Log = LoggerFactory.getLogger(WalletService.class);


    public List<Wallet> getAllWallets(String userId) {
        return walletRepo.findAll(userId);

    }


    public boolean createNewWallet(Wallet wallet, String ownerId) {

        Log.info("Save a new Wallet with public and private key: {}, {}",
                wallet.getPublicKey(), wallet.getPrivateKey()
        );

        if (walletRepo.find(wallet.getUserId()) != null) {
            return false;
        }

        wallet.setUserId(ownerId);
        walletRepo.create(wallet);

        return true;

    }

}
