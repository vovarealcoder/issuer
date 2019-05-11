package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Projects {
    private int idProject;
    private String name;
    private Timestamp created;
    private String description;
    @Singular("category")
    private Set<Categories> categoriee;
    @Singular
    private Set<Versions> versions;
    @Singular
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

    @Id
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

}
