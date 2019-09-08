package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "versions", schema = "public", catalog = "cdissuer")
public class Versions {
    private int idVersion;
    private String name;
    private Timestamp dateCreated;
    private Projects project;

    public Versions() {
    }

    public Versions(int idVersion, String name, Timestamp dateCreated, Projects project) {
        this.idVersion = idVersion;
        this.name = name;
        this.dateCreated = dateCreated;
        this.project = project;
    }

    public static VersionsBuilder builder() {
        return new VersionsBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_version", nullable = false)
    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
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
    @Column(name = "date_created", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }


    @ManyToOne
    @JoinColumn(name = "id_project")
    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Versions)) return false;
        final Versions other = (Versions) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdVersion() != other.getIdVersion()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        final Object this$project = this.getProject();
        final Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Versions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdVersion();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        final Object $project = this.getProject();
        result = result * PRIME + ($project == null ? 43 : $project.hashCode());
        return result;
    }

    public String toString() {
        return "Versions(idVersion=" + this.getIdVersion() + ", name=" + this.getName() + ", dateCreated=" + this.getDateCreated() + ", project=" + this.getProject() + ")";
    }

    public static class VersionsBuilder {
        private int idVersion;
        private String name;
        private Timestamp dateCreated;
        private Projects project;

        VersionsBuilder() {
        }

        public Versions.VersionsBuilder idVersion(int idVersion) {
            this.idVersion = idVersion;
            return this;
        }

        public Versions.VersionsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Versions.VersionsBuilder dateCreated(Timestamp dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Versions.VersionsBuilder project(Projects project) {
            this.project = project;
            return this;
        }

        public Versions build() {
            return new Versions(idVersion, name, dateCreated, project);
        }

        public String toString() {
            return "Versions.VersionsBuilder(idVersion=" + this.idVersion + ", name=" + this.name + ", dateCreated=" + this.dateCreated + ", project=" + this.project + ")";
        }
    }
}
