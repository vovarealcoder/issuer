package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Builder
@ToString
@EqualsAndHashCode
@Entity
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

    @Id
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


}
