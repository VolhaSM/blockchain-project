package blockchain.project.Service;

import blockchain.project.Pojo.Block;
import blockchain.project.web.ApplicationConfiguration;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 6;

    public static void main(String[] args) {

        blockchain.add(new Block("1 block", "0"));
        System.out.println("Trying to mine block 1...");
        blockchain.get(0).mineBloc(difficulty);

        blockchain.add(new Block("2 block", blockchain.get(blockchain.size()-1).getHash()));
        System.out.println("Trying to mine block 2...");
        blockchain.get(1).mineBloc(difficulty);

        blockchain.add(new Block("3 block", blockchain.get(blockchain.size()-1).getHash()));
        System.out.println("Trying to mine block 3...");
        blockchain.get(2).mineBloc(difficulty);

        System.out.println("/nBlockchain is Valid: " + isChainValid());


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);



    }

    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');


        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }






}
