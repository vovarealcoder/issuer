package ru.issuer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("securityService")
public class SecurityService {
    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    public boolean hasAccessRand() {
        boolean expr = System.currentTimeMillis() % 2 == 0;
        logger.info("expr: {}", expr);
        return expr;
    }
}
