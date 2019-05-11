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
public class Actions {
    private int idAction;

    public Actions(int idAction, int transaction, Integer changeType, String oldValue, String newValue, String message, Timestamp time, Issues issue, Users user) {
        this.idAction = idAction;
        this.transaction = transaction;
        this.changeType = changeType;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.message = message;
        this.time = time;
        this.issue = issue;
        this.user = user;
    }

    private int transaction;
    private Integer changeType;
    private String oldValue;
    private String newValue;
    private String message;
    private Timestamp time;
    private Issues issue;
    private Users user;

    public Actions() {
    }

    @Id
    @Column(name = "id_action", nullable = false)
    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    @Basic
    @Column(name = "transaction", nullable = false)
    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    @Basic
    @Column(name = "change_type", nullable = true)
    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    @Basic
    @Column(name = "old_value", nullable = true, length = -1)
    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    @Basic
    @Column(name = "new_value", nullable = true, length = -1)
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Basic
    @Column(name = "message", nullable = true, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name="id_issue", nullable=false)
    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }
    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


}
