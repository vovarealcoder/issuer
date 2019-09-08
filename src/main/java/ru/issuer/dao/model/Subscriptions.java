package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions", schema = "public", catalog = "cdissuer")
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

    public static SubscriptionsBuilder builder() {
        return new SubscriptionsBuilder();
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription", nullable = false)
    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Subscriptions)) return false;
        final Subscriptions other = (Subscriptions) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idSubscription = this.getIdSubscription();
        final Object other$idSubscription = other.getIdSubscription();
        if (this$idSubscription == null ? other$idSubscription != null : !this$idSubscription.equals(other$idSubscription))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Subscriptions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idSubscription = this.getIdSubscription();
        result = result * PRIME + ($idSubscription == null ? 43 : $idSubscription.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        return result;
    }

    public String toString() {
        return "Subscriptions(idSubscription=" + this.getIdSubscription() + ", user=" + this.getUser() + ", issue=" + this.getIssue() + ")";
    }

    public static class SubscriptionsBuilder {
        private Integer idSubscription;
        private Users user;
        private Issues issue;

        SubscriptionsBuilder() {
        }

        public Subscriptions.SubscriptionsBuilder idSubscription(Integer idSubscription) {
            this.idSubscription = idSubscription;
            return this;
        }

        public Subscriptions.SubscriptionsBuilder user(Users user) {
            this.user = user;
            return this;
        }

        public Subscriptions.SubscriptionsBuilder issue(Issues issue) {
            this.issue = issue;
            return this;
        }

        public Subscriptions build() {
            return new Subscriptions(idSubscription, user, issue);
        }

        public String toString() {
            return "Subscriptions.SubscriptionsBuilder(idSubscription=" + this.idSubscription + ", user=" + this.user + ", issue=" + this.issue + ")";
        }
    }
}
