package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "statuses", schema = "public", catalog = "cdissuer")
public class Statuses {
    private int idStatus;
    private String name;
    private Boolean closed;

    public Statuses() {
    }

    public Statuses(int idStatus, String name, Boolean closed) {
        this.idStatus = idStatus;
        this.name = name;
        this.closed = closed;
    }

    public static StatusesBuilder builder() {
        return new StatusesBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status", nullable = false)
    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "closed", nullable = true)
    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Statuses)) return false;
        final Statuses other = (Statuses) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdStatus() != other.getIdStatus()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$closed = this.getClosed();
        final Object other$closed = other.getClosed();
        if (this$closed == null ? other$closed != null : !this$closed.equals(other$closed)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Statuses;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdStatus();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $closed = this.getClosed();
        result = result * PRIME + ($closed == null ? 43 : $closed.hashCode());
        return result;
    }

    public String toString() {
        return "Statuses(idStatus=" + this.getIdStatus() + ", name=" + this.getName() + ", closed=" + this.getClosed() + ")";
    }

    public static class StatusesBuilder {
        private int idStatus;
        private String name;
        private Boolean closed;

        StatusesBuilder() {
        }

        public Statuses.StatusesBuilder idStatus(int idStatus) {
            this.idStatus = idStatus;
            return this;
        }

        public Statuses.StatusesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Statuses.StatusesBuilder closed(Boolean closed) {
            this.closed = closed;
            return this;
        }

        public Statuses build() {
            return new Statuses(idStatus, name, closed);
        }

        public String toString() {
            return "Statuses.StatusesBuilder(idStatus=" + this.idStatus + ", name=" + this.name + ", closed=" + this.closed + ")";
        }
    }
}
