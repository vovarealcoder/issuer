package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "permissions", schema = "public", catalog = "cdissuer")
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

    public static PermissionsBuilder builder() {
        return new PermissionsBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Permissions)) return false;
        final Permissions other = (Permissions) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdPermission() != other.getIdPermission()) return false;
        final Object this$canRead = this.getCanRead();
        final Object other$canRead = other.getCanRead();
        if (this$canRead == null ? other$canRead != null : !this$canRead.equals(other$canRead)) return false;
        final Object this$canWrite = this.getCanWrite();
        final Object other$canWrite = other.getCanWrite();
        if (this$canWrite == null ? other$canWrite != null : !this$canWrite.equals(other$canWrite)) return false;
        final Object this$canCreate = this.getCanCreate();
        final Object other$canCreate = other.getCanCreate();
        if (this$canCreate == null ? other$canCreate != null : !this$canCreate.equals(other$canCreate)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Permissions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdPermission();
        final Object $canRead = this.getCanRead();
        result = result * PRIME + ($canRead == null ? 43 : $canRead.hashCode());
        final Object $canWrite = this.getCanWrite();
        result = result * PRIME + ($canWrite == null ? 43 : $canWrite.hashCode());
        final Object $canCreate = this.getCanCreate();
        result = result * PRIME + ($canCreate == null ? 43 : $canCreate.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "Permissions(idPermission=" + this.getIdPermission() + ", canRead=" + this.getCanRead() + ", canWrite=" + this.getCanWrite() + ", canCreate=" + this.getCanCreate() + ", role=" + this.getRole() + ")";
    }

    public static class PermissionsBuilder {
        private int idPermission;
        private Boolean canRead;
        private Boolean canWrite;
        private Boolean canCreate;
        private Roles role;

        PermissionsBuilder() {
        }

        public Permissions.PermissionsBuilder idPermission(int idPermission) {
            this.idPermission = idPermission;
            return this;
        }

        public Permissions.PermissionsBuilder canRead(Boolean canRead) {
            this.canRead = canRead;
            return this;
        }

        public Permissions.PermissionsBuilder canWrite(Boolean canWrite) {
            this.canWrite = canWrite;
            return this;
        }

        public Permissions.PermissionsBuilder canCreate(Boolean canCreate) {
            this.canCreate = canCreate;
            return this;
        }

        public Permissions.PermissionsBuilder role(Roles role) {
            this.role = role;
            return this;
        }

        public Permissions build() {
            return new Permissions(idPermission, canRead, canWrite, canCreate, role);
        }

        public String toString() {
            return "Permissions.PermissionsBuilder(idPermission=" + this.idPermission + ", canRead=" + this.canRead + ", canWrite=" + this.canWrite + ", canCreate=" + this.canCreate + ", role=" + this.role + ")";
        }
    }
}
