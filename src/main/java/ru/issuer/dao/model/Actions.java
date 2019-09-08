package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "actions", schema = "public", catalog = "cdissuer")
public class Actions {
    private int idAction;
    private int transaction;
    private Integer changeType;
    private String oldValue;
    private String newValue;
    private String message;
    private Timestamp time;
    private Issues issue;
    private Users user;
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

    public Actions() {
    }

    public static ActionsBuilder builder() {
        return new ActionsBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "id_issue", nullable = false)
    public Issues getIssue() {
        return issue;
    }

    public void setIssue(Issues issue) {
        this.issue = issue;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Actions)) return false;
        final Actions other = (Actions) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdAction() != other.getIdAction()) return false;
        if (this.getTransaction() != other.getTransaction()) return false;
        final Object this$changeType = this.getChangeType();
        final Object other$changeType = other.getChangeType();
        if (this$changeType == null ? other$changeType != null : !this$changeType.equals(other$changeType))
            return false;
        final Object this$oldValue = this.getOldValue();
        final Object other$oldValue = other.getOldValue();
        if (this$oldValue == null ? other$oldValue != null : !this$oldValue.equals(other$oldValue)) return false;
        final Object this$newValue = this.getNewValue();
        final Object other$newValue = other.getNewValue();
        if (this$newValue == null ? other$newValue != null : !this$newValue.equals(other$newValue)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$time = this.getTime();
        final Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Actions;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdAction();
        result = result * PRIME + this.getTransaction();
        final Object $changeType = this.getChangeType();
        result = result * PRIME + ($changeType == null ? 43 : $changeType.hashCode());
        final Object $oldValue = this.getOldValue();
        result = result * PRIME + ($oldValue == null ? 43 : $oldValue.hashCode());
        final Object $newValue = this.getNewValue();
        result = result * PRIME + ($newValue == null ? 43 : $newValue.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $time = this.getTime();
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Actions(idAction=" + this.getIdAction() + ", transaction=" + this.getTransaction() + ", changeType=" + this.getChangeType() + ", oldValue=" + this.getOldValue() + ", newValue=" + this.getNewValue() + ", message=" + this.getMessage() + ", time=" + this.getTime() + ", issue=" + this.getIssue() + ", user=" + this.getUser() + ")";
    }

    public static class ActionsBuilder {
        private int idAction;
        private int transaction;
        private Integer changeType;
        private String oldValue;
        private String newValue;
        private String message;
        private Timestamp time;
        private Issues issue;
        private Users user;

        ActionsBuilder() {
        }

        public Actions.ActionsBuilder idAction(int idAction) {
            this.idAction = idAction;
            return this;
        }

        public Actions.ActionsBuilder transaction(int transaction) {
            this.transaction = transaction;
            return this;
        }

        public Actions.ActionsBuilder changeType(Integer changeType) {
            this.changeType = changeType;
            return this;
        }

        public Actions.ActionsBuilder oldValue(String oldValue) {
            this.oldValue = oldValue;
            return this;
        }

        public Actions.ActionsBuilder newValue(String newValue) {
            this.newValue = newValue;
            return this;
        }

        public Actions.ActionsBuilder message(String message) {
            this.message = message;
            return this;
        }

        public Actions.ActionsBuilder time(Timestamp time) {
            this.time = time;
            return this;
        }

        public Actions.ActionsBuilder issue(Issues issue) {
            this.issue = issue;
            return this;
        }

        public Actions.ActionsBuilder user(Users user) {
            this.user = user;
            return this;
        }

        public Actions build() {
            return new Actions(idAction, transaction, changeType, oldValue, newValue, message, time, issue, user);
        }

        public String toString() {
            return "Actions.ActionsBuilder(idAction=" + this.idAction + ", transaction=" + this.transaction + ", changeType=" + this.changeType + ", oldValue=" + this.oldValue + ", newValue=" + this.newValue + ", message=" + this.message + ", time=" + this.time + ", issue=" + this.issue + ", user=" + this.user + ")";
        }
    }
}
