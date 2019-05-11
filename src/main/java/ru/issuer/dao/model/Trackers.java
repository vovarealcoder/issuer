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
public class Trackers {
    private int idTracker;
    private String name;

    public Trackers() {
    }

    public Trackers(int idTracker, String name) {
        this.idTracker = idTracker;
        this.name = name;
    }

    @Id
    @Column(name = "id_tracker", nullable = false)
    public int getIdTracker() {
        return idTracker;
    }

    public void setIdTracker(int idTracker) {
        this.idTracker = idTracker;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
