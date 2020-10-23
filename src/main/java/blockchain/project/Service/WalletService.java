package blockchain.project.Service;

import blockchain.project.Pojo.Wallet;
import blockchain.project.Repository.GenericDao;
import blockchain.project.Repository.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletService {

//    @Autowired
//    @Value("#{recipientRepository}")
//    GenericDao<Recipeint> genericDao;

    @Autowired
    @Value("#{walletRepo}")
    GenericDao<Wallet> walletRepo;


    private static final Logger Log = LoggerFactory.getLogger(WalletService.class);


    public List<Wallet> getAllWallets(String userId) {
        return walletRepo.findAll(userId);

    }

//    public Wallet findWallet(String userId) {
//        return walletRepo.find(userId);
//    }

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



    @Transactional
    public Wallet findByWalletId(String walletId) {
        return walletRepo.find(walletId);
    }
}
