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
public class Files {
    private int idFile;
    private String path;
    private String displayName;
    private Timestamp added;
    private Issues issue;
    private Users user;

    public Files() {
    }

    public Files(int idFile, String path, String displayName, Timestamp added, Issues issue, Users user) {
        this.idFile = idFile;
        this.path = path;
        this.displayName = displayName;
        this.added = added;
        this.issue = issue;
        this.user = user;
    }

    @Id
    @Column(name = "id_file", nullable = false)
    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    @Basic
    @Column(name = "path", nullable = false, length = 500)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "display_name", nullable = false, length = 500)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "added", nullable = false)
    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
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
    @JoinColumn(name = "id_issue")
    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }


}
