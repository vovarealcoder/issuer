package ru.issuer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;

@Service
public class DbUserService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(DbUserService.class);
    private UserManager userManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userManager.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + username + " not found!");
        }
        logger.info("user is " + user);
        return new DbUserPrincipal(user);
    }
}
