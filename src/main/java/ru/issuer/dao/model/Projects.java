package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "projects", schema = "public", catalog = "cdissuer")
public class Projects {
    private int idProject;
    private String name;
    private Timestamp created;
    private String description;
    private Set<Categories> categoriee;
    private Set<Versions> versions;
    private Set<ProjectsParticipants> projectsParticipants;

    public Projects() {
    }

    public Projects(int idProject, String name, Timestamp created, String description, Set<Categories> categoriee, Set<Versions> versions, Set<ProjectsParticipants> projectsParticipants) {
        this.idProject = idProject;
        this.name = name;
        this.created = created;
        this.description = description;
        this.categoriee = categoriee;
        this.versions = versions;
        this.projectsParticipants = projectsParticipants;
    }

    public static ProjectsBuilder builder() {
        return new ProjectsBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project", nullable = false)
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "created", nullable = false)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @OneToMany
    @JoinColumn(name = "id_category")
    public Set<Categories> getCategoriee() {
        return categoriee;
    }

    public void setCategoriee(Set<Categories> categoriee) {
        this.categoriee = categoriee;
    }

    @OneToMany
    @JoinColumn(name = "id_version")
    public Set<Versions> getVersions() {
        return versions;
    }

    public void setVersions(Set<Versions> versions) {
        this.versions = versions;
    }

    @OneToMany
    @JoinColumn(name = "id_participant")
    public Set<ProjectsParticipants> getProjectsParticipants() {
        return projectsParticipants;
    }

    public void setProjectsParticipants(Set<ProjectsParticipants> projectsParticipants) {
        this.projectsParticipants = projectsParticipants;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Projects)) return false;
        final Projects other = (Projects) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdProject() != other.getIdProject()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$categoriee = this.getCategoriee();
        final Object other$categoriee = other.getCategoriee();
        if (this$categoriee == null ? other$categoriee != null : !this$categoriee.equals(other$categoriee))
            return false;
        final Object this$versions = this.getVersions();
        final Object other$versions = other.getVersions();
        if (this$versions == null ? other$versions != null : !this$versions.equals(other$versions)) return false;
        final Object this$projectsParticipants = this.getProjectsParticipants();
        final Object other$projectsParticipants = other.getProjectsParticipants();
        if (this$projectsParticipants == null ? other$projectsParticipants != null : !this$projectsParticipants.equals(other$projectsParticipants))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Projects;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdProject();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $categoriee = this.getCategoriee();
        result = result * PRIME + ($categoriee == null ? 43 : $categoriee.hashCode());
        final Object $versions = this.getVersions();
        result = result * PRIME + ($versions == null ? 43 : $versions.hashCode());
        final Object $projectsParticipants = this.getProjectsParticipants();
        result = result * PRIME + ($projectsParticipants == null ? 43 : $projectsParticipants.hashCode());
        return result;
    }

    public String toString() {
        return "Projects(idProject=" + this.getIdProject() + ", name=" + this.getName() + ", created=" + this.getCreated() + ", description=" + this.getDescription() + ", categoriee=" + this.getCategoriee() + ", versions=" + this.getVersions() + ", projectsParticipants=" + this.getProjectsParticipants() + ")";
    }

    public static class ProjectsBuilder {
        private int idProject;
        private String name;
        private Timestamp created;
        private String description;
        private ArrayList<Categories> categoriee;
        private ArrayList<Versions> versions;
        private ArrayList<ProjectsParticipants> projectsParticipants;

        ProjectsBuilder() {
        }

        public Projects.ProjectsBuilder idProject(int idProject) {
            this.idProject = idProject;
            return this;
        }

        public Projects.ProjectsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Projects.ProjectsBuilder created(Timestamp created) {
            this.created = created;
            return this;
        }

        public Projects.ProjectsBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Projects.ProjectsBuilder category(Categories category) {
            if (this.categoriee == null) this.categoriee = new ArrayList<Categories>();
            this.categoriee.add(category);
            return this;
        }

        public Projects.ProjectsBuilder categoriee(Collection<? extends Categories> categoriee) {
            if (this.categoriee == null) this.categoriee = new ArrayList<Categories>();
            this.categoriee.addAll(categoriee);
            return this;
        }

        public Projects.ProjectsBuilder clearCategoriee() {
            if (this.categoriee != null)
                this.categoriee.clear();

            return this;
        }

        public Projects.ProjectsBuilder version(Versions version) {
            if (this.versions == null) this.versions = new ArrayList<Versions>();
            this.versions.add(version);
            return this;
        }

        public Projects.ProjectsBuilder versions(Collection<? extends Versions> versions) {
            if (this.versions == null) this.versions = new ArrayList<Versions>();
            this.versions.addAll(versions);
            return this;
        }

        public Projects.ProjectsBuilder clearVersions() {
            if (this.versions != null)
                this.versions.clear();

            return this;
        }

        public Projects.ProjectsBuilder projectsParticipant(ProjectsParticipants projectsParticipant) {
            if (this.projectsParticipants == null)
                this.projectsParticipants = new ArrayList<ProjectsParticipants>();
            this.projectsParticipants.add(projectsParticipant);
            return this;
        }

        public Projects.ProjectsBuilder projectsParticipants(Collection<? extends ProjectsParticipants> projectsParticipants) {
            if (this.projectsParticipants == null)
                this.projectsParticipants = new ArrayList<ProjectsParticipants>();
            this.projectsParticipants.addAll(projectsParticipants);
            return this;
        }

        public Projects.ProjectsBuilder clearProjectsParticipants() {
            if (this.projectsParticipants != null)
                this.projectsParticipants.clear();

            return this;
        }

        public Projects build() {
            Set<Categories> categoriee;
            switch (this.categoriee == null ? 0 : this.categoriee.size()) {
                case 0:
                    categoriee = java.util.Collections.emptySet();
                    break;
                case 1:
                    categoriee = java.util.Collections.singleton(this.categoriee.get(0));
                    break;
                default:
                    categoriee = new java.util.LinkedHashSet<Categories>(this.categoriee.size() < 1073741824 ? 1 + this.categoriee.size() + (this.categoriee.size() - 3) / 3 : Integer.MAX_VALUE);
                    categoriee.addAll(this.categoriee);
                    categoriee = java.util.Collections.unmodifiableSet(categoriee);
            }
            Set<Versions> versions;
            switch (this.versions == null ? 0 : this.versions.size()) {
                case 0:
                    versions = java.util.Collections.emptySet();
                    break;
                case 1:
                    versions = java.util.Collections.singleton(this.versions.get(0));
                    break;
                default:
                    versions = new java.util.LinkedHashSet<Versions>(this.versions.size() < 1073741824 ? 1 + this.versions.size() + (this.versions.size() - 3) / 3 : Integer.MAX_VALUE);
                    versions.addAll(this.versions);
                    versions = java.util.Collections.unmodifiableSet(versions);
            }
            Set<ProjectsParticipants> projectsParticipants;
            switch (this.projectsParticipants == null ? 0 : this.projectsParticipants.size()) {
                case 0:
                    projectsParticipants = java.util.Collections.emptySet();
                    break;
                case 1:
                    projectsParticipants = java.util.Collections.singleton(this.projectsParticipants.get(0));
                    break;
                default:
                    projectsParticipants = new java.util.LinkedHashSet<ProjectsParticipants>(this.projectsParticipants.size() < 1073741824 ? 1 + this.projectsParticipants.size() + (this.projectsParticipants.size() - 3) / 3 : Integer.MAX_VALUE);
                    projectsParticipants.addAll(this.projectsParticipants);
                    projectsParticipants = java.util.Collections.unmodifiableSet(projectsParticipants);
            }

            return new Projects(idProject, name, created, description, categoriee, versions, projectsParticipants);
        }

        public String toString() {
            return "Projects.ProjectsBuilder(idProject=" + this.idProject + ", name=" + this.name + ", created=" + this.created + ", description=" + this.description + ", categoriee=" + this.categoriee + ", versions=" + this.versions + ", projectsParticipants=" + this.projectsParticipants + ")";
        }
    }
}
