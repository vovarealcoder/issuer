package ru.issuer.web.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import ru.issuer.dao.model.Roles;
import ru.issuer.dao.model.Users;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RegisterModel implements WebModel<Users> {
    @Size(min = 6, max = 18, message = "{loginLen}")
    @Pattern(regexp = "[a-zA-Z0-9\\-]+", message = "{loginChar}")
    private String login;
    @Size(min = 8, max = 18, message = "{passwordLen}")
    private String password;
    private String passwordRetype;
    @Size(min = 5, max = 20, message = "{nameLen}")
    private String name;
    @Email(message = "{emailValid}")
    private String email;

    public RegisterModel() {
    }

    public RegisterModel(String login, String password, String passwordRetype, String name, String email) {
        this.login = login;
        this.password = password;
        this.passwordRetype = passwordRetype;
        this.name = name;
        this.email = email;
    }

    @AssertTrue(message = "Password and password confirm must be equals")
    private boolean getPasswordRetypeSuccess() {
        return password != null && password.equals(passwordRetype);
    }

    @Override
    public Users toORMModel() {
        return Users
                .builder()
                .login(getLogin())
                .password(getPassword())
                .name(getName())
                .email(getEmail())
                .role(Roles.builder().idRole(1).build())
                .build();
    }
}
