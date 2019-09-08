package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "public", catalog = "cdissuer")
public class Roles {
    private int idRole;
    private String name;
    private Permissions permission;

    public Roles() {
    }

    public Roles(int idRole, String name, Permissions permission) {
        this.idRole = idRole;
        this.name = name;
        this.permission = permission;
    }

    public static RolesBuilder builder() {
        return new RolesBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToOne
    @JoinColumn(name = "id_role")
    public Permissions getPermission() {
        return permission;
    }

    public void setPermission(Permissions permission) {
        this.permission = permission;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Roles)) return false;
        final Roles other = (Roles) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdRole() != other.getIdRole()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$permission = this.getPermission();
        final Object other$permission = other.getPermission();
        if (this$permission == null ? other$permission != null : !this$permission.equals(other$permission))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Roles;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdRole();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $permission = this.getPermission();
        result = result * PRIME + ($permission == null ? 43 : $permission.hashCode());
        return result;
    }

    public String toString() {
        return "Roles(idRole=" + this.getIdRole() + ", name=" + this.getName() + ", permission=" + this.getPermission() + ")";
    }

    public static class RolesBuilder {
        private int idRole;
        private String name;
        private Permissions permission;

        RolesBuilder() {
        }

        public Roles.RolesBuilder idRole(int idRole) {
            this.idRole = idRole;
            return this;
        }

        public Roles.RolesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Roles.RolesBuilder permission(Permissions permission) {
            this.permission = permission;
            return this;
        }

        public Roles build() {
            return new Roles(idRole, name, permission);
        }

        public String toString() {
            return "Roles.RolesBuilder(idRole=" + this.idRole + ", name=" + this.name + ", permission=" + this.permission + ")";
        }
    }
}
