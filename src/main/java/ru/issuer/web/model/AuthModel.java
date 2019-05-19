package ru.issuer.web.model;

import lombok.*;
import ru.issuer.dao.model.Users;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthModel implements WebModel<Users> {


    @Size(min = 5, max = 18, message = "{loginLen}")
    @Pattern(regexp = "[a-zA-Z0-9\\-]+", message = "{loginChar}")
    private String login;
    @Size(min = 5, max = 18, message = "{passwordLen}")
    private String password;

    public AuthModel() {
    }

    public AuthModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Users toORMModel() {
        return Users.builder().login(this.login).password(this.password).build();
    }
}
