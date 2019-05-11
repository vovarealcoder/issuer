package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Builder
@ToString
@EqualsAndHashCode
@Entity
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

    @Id
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


}
