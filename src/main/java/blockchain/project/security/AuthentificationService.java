package blockchain.project.security;

import blockchain.project.Pojo.BlockchainUser;
import blockchain.project.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("authService")
public class AuthentificationService implements UserDetailsService {

    private static final Logger Log = LoggerFactory.getLogger(AuthentificationService.class);


    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)  {
        Log.info("calling method loadUserByUserName: {}", userName);
        BlockchainUser user = userService.findByUserName(userName);

        if(user == null) throw new UsernameNotFoundException("User not found: " + userName);

        return  new User(
                user.getUserName(),
                user.getUserPassword(),
                user.getRoles().
                        stream().
                        map(appRole -> new SimpleGrantedAuthority("ROLE_" + appRole.getRoleName()))
                        .collect(Collectors.toList())
        );
    }
}
