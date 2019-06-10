package ru.issuer.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;

public class SecUtils {


    public static Users getUserByContext(UserManager repos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        boolean authenticated = authentication.isAuthenticated();
        if (!authenticated) {
            return null;
        }
        DbUserPrincipal principal = (DbUserPrincipal) authentication.getPrincipal();
        String username = principal.getUsername();
        return repos.getUser(username);
    }
}
