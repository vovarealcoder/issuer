package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Builder
@ToString
@EqualsAndHashCode
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

    @Id
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

}
