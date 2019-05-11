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
public class Work {
    private int idWork;
    private Timestamp time;
    private double hours;
    private String comment;
    private Issues issue;
    private WorkType workType;
    private Users user;

    public Work() {
    }

    public Work(int idWork, Timestamp time, double hours, String comment, Issues issue, WorkType workType, Users user) {
        this.idWork = idWork;
        this.time = time;
        this.hours = hours;
        this.comment = comment;
        this.issue = issue;
        this.workType = workType;
        this.user = user;
    }

    @Id
    @Column(name = "id_work", nullable = false)
    public int getIdWork() {
        return idWork;
    }

    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "hours", nullable = false, precision = 0)
    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @ManyToOne
    @JoinColumn(name = "id_issue")
    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }
    @ManyToOne
    @JoinColumn(name = "work_type", referencedColumnName = "id_work_type")
    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }
    @ManyToOne
    @JoinColumn(name = "id_user")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
