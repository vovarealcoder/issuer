package ru.issuer.web.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;
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
    @Size(min = 6, max = 18, message = "Login length must be from 6 to 18 characters")
    @Pattern(regexp = "[a-zA-Z0-9\\-]+", message = "Login must contains from alphabet characters, numeric ans -")
    private String Login;
    @Size(min = 8, max = 18, message = "Password must have length from 8 to 18 characters")
    private String password;
    private String passwordRetype;
    @Size(min = 5, max = 20, message = "Name length must be from 6 to 18 characters")
    private String name;
    @Email(message = "Email is not valid")
    private String email;

    @AssertTrue(message = "Password and password confirm must be equals")
    private boolean passwordRetypeSuccess() {
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
                .build();
    }
}
