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
@Table(name = "task_link", schema = "public", catalog = "cdissuer")
public class TaskLink {
    public TaskLink(int idLink, Boolean copied, Issues oneIssue, Issues twoIssue) {
        this.idLink = idLink;
        this.copied = copied;
        this.oneIssue = oneIssue;
        this.twoIssue = twoIssue;
    }

    private int idLink;
    private Boolean copied;
    private Issues oneIssue;
    private Issues twoIssue;

    public TaskLink() {
    }

    @Id
    @Column(name = "id_link", nullable = false)
    public int getIdLink() {
        return idLink;
    }

    public void setIdLink(int idLink) {
        this.idLink = idLink;
    }

    @Basic
    @Column(name = "copied", nullable = true)
    public Boolean getCopied() {
        return copied;
    }

    public void setCopied(Boolean copied) {
        this.copied = copied;
    }

    @ManyToOne
    @JoinColumn(name = "two",referencedColumnName = "id_issue")
    public Issues getTwoIssue() {
        return twoIssue;
    }

    public void setTwoIssue(Issues twoIssue) {
        this.twoIssue = twoIssue;
    }
    @ManyToOne
    @JoinColumn(name = "one",referencedColumnName = "id_issue")
    public Issues getOneIssue() {
        return oneIssue;
    }

    public void setOneIssue(Issues oneIssue) {
        this.oneIssue = oneIssue;
    }

}
