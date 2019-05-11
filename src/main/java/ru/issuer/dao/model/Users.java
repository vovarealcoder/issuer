package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Users {
    private int idUser;
    @Size(min = 6, max = 18, message = "Login length must be from 6 to 18 characters")
    @Pattern(regexp = "[a-zA-Z0-9\\-]+", message = "Login must contains from alphabet characters, numeric ans -")
    private String login;
    @Size(min = 8, max = 18, message = "Password must have length from 8 to 18 characters")
    private String password;
    private String name;
    private Timestamp registrated;
    private String email;
    private boolean activated;
    private Avatar avatar;
    private Roles role;
    private Timestamp lastLogin;

    public Users(int idUser, String login, String password, String name, Timestamp registrated, String email, boolean activated, Avatar avatar, Roles role, Timestamp lastLogin) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.name = name;
        this.registrated = registrated;
        this.email = email;
        this.activated = activated;
        this.avatar = avatar;
        this.role = role;
        this.lastLogin = lastLogin;
    }

    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 200)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    @ColumnTransformer(read = "pgp_sym_decrypt(password, 'qazwsx')", write = "pgp_sym_encrypt(?, 'qazwsx')")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "registrated", nullable = false, insertable = false)
    public Timestamp getRegistrated() {
        return registrated;
    }

    public void setRegistrated(Timestamp registrated) {
        this.registrated = registrated;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "activated", nullable = false, insertable = false)
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "user_loaded", insertable = false)
    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id_role")
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Basic
    @Column(name = "last_login", insertable = false)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
}
