package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@ToString
@EqualsAndHashCode
@Entity
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

    @Id
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


}
