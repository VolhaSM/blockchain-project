package blockchain.project.Pojo;

import java.security.PublicKey;

public class BlockTransactions {


//
//    public String transactionId; // this is also the hash of the transaction.
//    public PublicKey sender; // senders address/public key.
//    public PublicKey recipient; // Recipients address/public key.
//    public float value;
//    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.
//
//    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
//    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
//
//    private static int sequence = 0; // a rough count of how many transactions have been generated.
//
//    // Constructor:
//    public BlockTransactions(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
//        this.sender = from;
//        this.recipient = to;
//        this.value = value;
//        this.inputs = inputs;
//    }

//    // This Calculates the transaction hash (which will be used as its Id)
//    private String calculateHash() {
//        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
//        return BlockUtil.applySHA256(
//                BlockUtil.getStringFromKey(sender) +
//                        BlockUtil.getStringFromKey(recipient) +
//                        Float.toString(value) + sequence
//        );
//    }
}
