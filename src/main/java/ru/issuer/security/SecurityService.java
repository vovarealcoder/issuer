package ru.issuer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;

@Component("securityService")
public class SecurityService {


    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    private UserManager userManager;

    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    public boolean hasAccessRand() {
        boolean expr = System.currentTimeMillis() % 2 == 0;
        logger.info("expr: {}", expr);
        return expr;
    }

    public Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        boolean authenticated = authentication.isAuthenticated();
        if (!authenticated) {
            return null;
        }
        logger.info("principal: {}",authentication.getPrincipal());
        if(authentication.getPrincipal() instanceof DbUserPrincipal) {
            DbUserPrincipal principal = (DbUserPrincipal) authentication.getPrincipal();
            String username = principal.getUsername();
            return userManager.getUser(username);
        }
        return null;
    }
}
