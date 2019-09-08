package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "work_type", schema = "public", catalog = "cdissuer")
public class WorkType {
    private int idWorkType;
    private String name;

    public WorkType(int idWorkType, String name) {
        this.idWorkType = idWorkType;
        this.name = name;
    }

    public WorkType() {
    }

    public static WorkTypeBuilder builder() {
        return new WorkTypeBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work_type", nullable = false)
    public int getIdWorkType() {
        return idWorkType;
    }

    public void setIdWorkType(int idWorkType) {
        this.idWorkType = idWorkType;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WorkType)) return false;
        final WorkType other = (WorkType) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdWorkType() != other.getIdWorkType()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WorkType;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdWorkType();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "WorkType(idWorkType=" + this.getIdWorkType() + ", name=" + this.getName() + ")";
    }

    public static class WorkTypeBuilder {
        private int idWorkType;
        private String name;

        WorkTypeBuilder() {
        }

        public WorkType.WorkTypeBuilder idWorkType(int idWorkType) {
            this.idWorkType = idWorkType;
            return this;
        }

        public WorkType.WorkTypeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public WorkType build() {
            return new WorkType(idWorkType, name);
        }

        public String toString() {
            return "WorkType.WorkTypeBuilder(idWorkType=" + this.idWorkType + ", name=" + this.name + ")";
        }
    }
}
