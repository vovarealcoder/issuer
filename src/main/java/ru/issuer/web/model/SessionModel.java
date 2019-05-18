package ru.issuer.web.model;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.issuer.dao.model.Users;

@Component
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SessionModel {
    private Users user;
    private String sessionId;
    private boolean autorized;

    public SessionModel() {
        autorized = false;
    }

    public SessionModel(Users user, String sessionId, boolean autorized) {
        this.user = user;
        this.sessionId = sessionId;
        this.autorized = autorized;
    }

    @Bean(name = "session")
    @Scope(value = WebApplicationContext.SCOPE_SESSION)
    public SessionModel session() {
        return new SessionModel();
    }
}
