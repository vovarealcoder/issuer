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
@Table(name = "projects_participants", schema = "public", catalog = "cdissuer")
public class ProjectsParticipants {
    private int idParticipant;
    private Projects project;
    private Users user;
    private Roles roles;

    public ProjectsParticipants() {
    }

    public ProjectsParticipants(int idParticipant, Projects project, Users user, Roles roles) {
        this.idParticipant = idParticipant;
        this.project = project;
        this.user = user;
        this.roles = roles;
    }

    @Id
    @Column(name = "id_participant", nullable = false)
    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
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


}
