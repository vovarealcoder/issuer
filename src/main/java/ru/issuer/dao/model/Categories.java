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
public class Categories {
    private int idCategory;
    private String name;
    private Projects project;

    public Categories() {
    }

    public Categories(int idCategory, String name, Projects project) {
        this.idCategory = idCategory;
        this.name = name;
        this.project = project;
    }

    @Id
    @Column(name = "id_category", nullable = false)
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
