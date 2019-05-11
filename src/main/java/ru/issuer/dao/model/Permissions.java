package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Permissions {
    private int idPermission;
    private Boolean canRead;
    private Boolean canWrite;
    private Boolean canCreate;
    private Roles role;

    public Permissions() {
    }

    public Permissions(int idPermission, Boolean canRead, Boolean canWrite, Boolean canCreate, Roles role) {
        this.idPermission = idPermission;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canCreate = canCreate;
        this.role = role;
    }

    @Id
    @Column(name = "id_permission", nullable = false)
    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    @Basic
    @Column(name = "can_read", nullable = true)
    public Boolean getCanRead() {
        return canRead;
    }

    public void setCanRead(Boolean canRead) {
        this.canRead = canRead;
    }

    @Basic
    @Column(name = "can_write", nullable = true)
    public Boolean getCanWrite() {
        return canWrite;
    }

    public void setCanWrite(Boolean canWrite) {
        this.canWrite = canWrite;
    }

    @Basic
    @Column(name = "can_create", nullable = true)
    public Boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Boolean canCreate) {
        this.canCreate = canCreate;
    }


    @OneToOne
    @JoinColumn(name = "id_role")
    public Roles getRole() {
        return role;
    }


    public void setRole(Roles role) {
        this.role = role;
    }


}
