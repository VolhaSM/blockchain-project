package blockchain.project.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class BlockTransactions {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    public String id; // this is also the hash of the transaction.
    public String sender; // senders address/public key.
    public String recipient; // Recipients address/public key.
    public float value;
//    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.
//

}
