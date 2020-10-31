package blockchain.project.Service;

import blockchain.project.Pojo.Block;
import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Repository.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    @Value("#{userRepo}")
    GenericDao<BlockchainUser> userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger Log = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public boolean createNewUser(BlockchainUser user) {
        final String encodedPassword = passwordEncoder.encode(user.getUserPassword());

        Log.info("Save a new User with name amd password: {} {}",
                user.getUserName(), encodedPassword
        );

        if (userRepository.find(user.getUserName()) == null)
        {

            user.setUserPassword(encodedPassword);
            userRepository.create(user);
            return true;
        }
        return false;

    }

    public static String getUsernameAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();//get logged in username
    }

    @Transactional
    public BlockchainUser findByUserName(String username) {

        return userRepository.find(username);
    }
}
