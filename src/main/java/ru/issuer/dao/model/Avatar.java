package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Avatar {
    private int idAvatar;
    private Timestamp loadTime;
    private String pathFull;
    private String pathMin;
    private String pathMed;
    private Users userLoaded;

    public Avatar() {
    }

    public Avatar(int idAvatar, Timestamp loadTime, String pathFull, String pathMin, String pathMed, Users userLoaded) {
        this.idAvatar = idAvatar;
        this.loadTime = loadTime;
        this.pathFull = pathFull;
        this.pathMin = pathMin;
        this.pathMed = pathMed;
        this.userLoaded = userLoaded;
    }

    @Id
    @Column(name = "id_avatar", nullable = false)
    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    @Basic
    @Column(name = "load_time", nullable = false)
    public Timestamp getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Timestamp loadTime) {
        this.loadTime = loadTime;
    }

    @Basic
    @Column(name = "path_full", nullable = false, length = 500)
    public String getPathFull() {
        return pathFull;
    }

    public void setPathFull(String pathFull) {
        this.pathFull = pathFull;
    }

    @Basic
    @Column(name = "path_min", nullable = true, length = 500)
    public String getPathMin() {
        return pathMin;
    }

    public void setPathMin(String pathMin) {
        this.pathMin = pathMin;
    }

    @Basic
    @Column(name = "path_med", nullable = true, length = 500)
    public String getPathMed() {
        return pathMed;
    }

    public void setPathMed(String pathMed) {
        this.pathMed = pathMed;
    }


    @OneToOne
    @JoinColumn(name = "user_loaded", referencedColumnName = "id_user")
    public Users getUserLoaded() {
        return userLoaded;
    }

    public void setUserLoaded(Users userLoaded) {
        this.userLoaded = userLoaded;
    }


}
