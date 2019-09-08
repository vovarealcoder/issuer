package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users", schema = "public", catalog = "cdissuer")
public class Users {
    private int idUser;
    private String login;
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

    public static UsersBuilder builder() {
        return new UsersBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Users)) return false;
        final Users other = (Users) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdUser() != other.getIdUser()) return false;
        final Object this$login = this.getLogin();
        final Object other$login = other.getLogin();
        if (this$login == null ? other$login != null : !this$login.equals(other$login)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$registrated = this.getRegistrated();
        final Object other$registrated = other.getRegistrated();
        if (this$registrated == null ? other$registrated != null : !this$registrated.equals(other$registrated))
            return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        if (this.isActivated() != other.isActivated()) return false;
        final Object this$avatar = this.getAvatar();
        final Object other$avatar = other.getAvatar();
        if (this$avatar == null ? other$avatar != null : !this$avatar.equals(other$avatar)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$lastLogin = this.getLastLogin();
        final Object other$lastLogin = other.getLastLogin();
        if (this$lastLogin == null ? other$lastLogin != null : !this$lastLogin.equals(other$lastLogin)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Users;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdUser();
        final Object $login = this.getLogin();
        result = result * PRIME + ($login == null ? 43 : $login.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $registrated = this.getRegistrated();
        result = result * PRIME + ($registrated == null ? 43 : $registrated.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        result = result * PRIME + (this.isActivated() ? 79 : 97);
        final Object $avatar = this.getAvatar();
        result = result * PRIME + ($avatar == null ? 43 : $avatar.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $lastLogin = this.getLastLogin();
        result = result * PRIME + ($lastLogin == null ? 43 : $lastLogin.hashCode());
        return result;
    }

    public String toString() {
        return "Users(idUser=" + this.getIdUser() + ", login=" + this.getLogin() + ", password=" + this.getPassword() + ", name=" + this.getName() + ", registrated=" + this.getRegistrated() + ", email=" + this.getEmail() + ", activated=" + this.isActivated() + ", avatar=" + this.getAvatar() + ", role=" + this.getRole() + ", lastLogin=" + this.getLastLogin() + ")";
    }

    public static class UsersBuilder {
        private int idUser;
        private String login;
        private String password;
        private String name;
        private Timestamp registrated;
        private String email;
        private boolean activated;
        private Avatar avatar;
        private Roles role;
        private Timestamp lastLogin;

        UsersBuilder() {
        }

        public Users.UsersBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public Users.UsersBuilder login(String login) {
            this.login = login;
            return this;
        }

        public Users.UsersBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Users.UsersBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Users.UsersBuilder registrated(Timestamp registrated) {
            this.registrated = registrated;
            return this;
        }

        public Users.UsersBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Users.UsersBuilder activated(boolean activated) {
            this.activated = activated;
            return this;
        }

        public Users.UsersBuilder avatar(Avatar avatar) {
            this.avatar = avatar;
            return this;
        }

        public Users.UsersBuilder role(Roles role) {
            this.role = role;
            return this;
        }

        public Users.UsersBuilder lastLogin(Timestamp lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public Users build() {
            return new Users(idUser, login, password, name, registrated, email, activated, avatar, role, lastLogin);
        }

        public String toString() {
            return "Users.UsersBuilder(idUser=" + this.idUser + ", login=" + this.login + ", password=" + this.password + ", name=" + this.name + ", registrated=" + this.registrated + ", email=" + this.email + ", activated=" + this.activated + ", avatar=" + this.avatar + ", role=" + this.role + ", lastLogin=" + this.lastLogin + ")";
        }
    }
}
