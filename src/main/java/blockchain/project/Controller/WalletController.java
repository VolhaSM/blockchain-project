package blockchain.project.Controller;

import blockchain.project.Pojo.Wallet;
import blockchain.project.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/user/{id}/wallets")
    public List<Wallet> wallets(@PathVariable String id) {
        return walletService.getAllWallets(id);


    }

//    @GetMapping("/user/{id}/wallet/{id}")
//    public Wallet wallet (@PathVariable String id, @PathVariable String walletId) {
//        return walletService.findWallet(id, walletId);
//    }


    @PostMapping("/wallets/{id}/wallet")
    public void createNewWallet(@PathVariable String id,
                                  @RequestBody Wallet wallet) {
        walletService.createNewWallet(id, wallet);
    }
}
