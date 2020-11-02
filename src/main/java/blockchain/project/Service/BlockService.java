package blockchain.project.Service;

import blockchain.project.Pojo.Block;
import blockchain.project.Pojo.Wallet;
import blockchain.project.Repository.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {


    private static final Logger Log = LoggerFactory.getLogger(BlockService.class);

    @Autowired
    @Value("#{blockRepo}")
    GenericDao<Block> blockRepo;



    public List<Block> findAllBlocks(String walletId) {

        Log.info("All Blocks list : {}", blockRepo.findAll(walletId));
        return blockRepo.findAll(walletId);
    }

}
