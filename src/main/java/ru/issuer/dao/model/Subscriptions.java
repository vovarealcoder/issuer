package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Subscriptions {

    private Integer idSubscription;
    private Users user;
    private Issues issue;

    public Subscriptions() {
    }

    public Subscriptions(Integer idSubscription, Users user, Issues issue) {
        this.idSubscription = idSubscription;
        this.user = user;
        this.issue = issue;
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

    @Id
    @Column(name = "id_subscription", nullable = false)
    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }


}
