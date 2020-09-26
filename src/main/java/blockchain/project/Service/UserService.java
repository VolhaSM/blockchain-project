package blockchain.project.Service;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void createNewUser(BlockchainUser user) {
        final String encodedPassword = passwordEncoder.encode(user.getUserPassword());


        user.setUserPassword(encodedPassword);
        userRepository.create(user);

    }
    @Transactional
    public BlockchainUser findByUserName(String username) {

        return userRepository.find(username);
    }
}
