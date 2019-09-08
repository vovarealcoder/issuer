package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "projects_participants", schema = "public", catalog = "cdissuer")
public class ProjectsParticipants {
    private Integer idParticipant;
    private Projects project;
    private Users user;
    private Roles roles;

    public ProjectsParticipants() {
    }

    public ProjectsParticipants(Integer idParticipant, Projects project, Users user, Roles roles) {
        this.idParticipant = idParticipant;
        this.project = project;
        this.user = user;
        this.roles = roles;
    }

    public static ProjectsParticipantsBuilder builder() {
        return new ProjectsParticipantsBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant", nullable = false)
    public Integer getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Integer idParticipant) {
        this.idParticipant = idParticipant;
    }


    @ManyToOne
    @JoinColumn(name = "id_project")
    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "id_user")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id_role")
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjectsParticipants)) return false;
        final ProjectsParticipants other = (ProjectsParticipants) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idParticipant = this.getIdParticipant();
        final Object other$idParticipant = other.getIdParticipant();
        if (this$idParticipant == null ? other$idParticipant != null : !this$idParticipant.equals(other$idParticipant))
            return false;
        final Object this$project = this.getProject();
        final Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProjectsParticipants;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idParticipant = this.getIdParticipant();
        result = result * PRIME + ($idParticipant == null ? 43 : $idParticipant.hashCode());
        final Object $project = this.getProject();
        result = result * PRIME + ($project == null ? 43 : $project.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        return result;
    }

    public String toString() {
        return "ProjectsParticipants(idParticipant=" + this.getIdParticipant() + ", project=" + this.getProject() + ", user=" + this.getUser() + ", roles=" + this.getRoles() + ")";
    }

    public static class ProjectsParticipantsBuilder {
        private Integer idParticipant;
        private Projects project;
        private Users user;
        private Roles roles;

        ProjectsParticipantsBuilder() {
        }

        public ProjectsParticipants.ProjectsParticipantsBuilder idParticipant(Integer idParticipant) {
            this.idParticipant = idParticipant;
            return this;
        }

        public ProjectsParticipants.ProjectsParticipantsBuilder project(Projects project) {
            this.project = project;
            return this;
        }

        public ProjectsParticipants.ProjectsParticipantsBuilder user(Users user) {
            this.user = user;
            return this;
        }

        public ProjectsParticipants.ProjectsParticipantsBuilder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public ProjectsParticipants build() {
            return new ProjectsParticipants(idParticipant, project, user, roles);
        }

        public String toString() {
            return "ProjectsParticipants.ProjectsParticipantsBuilder(idParticipant=" + this.idParticipant + ", project=" + this.project + ", user=" + this.user + ", roles=" + this.roles + ")";
        }
    }
}
