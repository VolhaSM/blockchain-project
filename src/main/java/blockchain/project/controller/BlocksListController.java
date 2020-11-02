package blockchain.project.controller;

import blockchain.project.pojo.Block;
import blockchain.project.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlocksListController {

    @Autowired
    BlockService blockService;

    private final static Logger Log = LoggerFactory.getLogger(BlocksListController.class);

    @GetMapping("/{walletId}/blocks-list")
    public ModelAndView findAllMinedBlocks(
            @PathVariable String walletId,
            ModelAndView modelAndView
    ) {

        Log.info("ALL BLOCKS LIST {}", blockService.findAllBlocks(walletId));

        List<Block> blocks = blockService.findAllBlocks(walletId);

        modelAndView.setViewName("blocks-list");
        modelAndView.addObject("blocks", blocks);

        return modelAndView;

    }
}
