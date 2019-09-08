package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "work", schema = "public", catalog = "cdissuer")
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

    public static WorkBuilder builder() {
        return new WorkBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Work)) return false;
        final Work other = (Work) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdWork() != other.getIdWork()) return false;
        final Object this$time = this.getTime();
        final Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
        if (Double.compare(this.getHours(), other.getHours()) != 0) return false;
        final Object this$comment = this.getComment();
        final Object other$comment = other.getComment();
        if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment)) return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        final Object this$workType = this.getWorkType();
        final Object other$workType = other.getWorkType();
        if (this$workType == null ? other$workType != null : !this$workType.equals(other$workType)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Work;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdWork();
        final Object $time = this.getTime();
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final long $hours = Double.doubleToLongBits(this.getHours());
        result = result * PRIME + (int) ($hours >>> 32 ^ $hours);
        final Object $comment = this.getComment();
        result = result * PRIME + ($comment == null ? 43 : $comment.hashCode());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        final Object $workType = this.getWorkType();
        result = result * PRIME + ($workType == null ? 43 : $workType.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Work(idWork=" + this.getIdWork() + ", time=" + this.getTime() + ", hours=" + this.getHours() + ", comment=" + this.getComment() + ", issue=" + this.getIssue() + ", workType=" + this.getWorkType() + ", user=" + this.getUser() + ")";
    }

    public static class WorkBuilder {
        private int idWork;
        private Timestamp time;
        private double hours;
        private String comment;
        private Issues issue;
        private WorkType workType;
        private Users user;

        WorkBuilder() {
        }

        public Work.WorkBuilder idWork(int idWork) {
            this.idWork = idWork;
            return this;
        }

        public Work.WorkBuilder time(Timestamp time) {
            this.time = time;
            return this;
        }

        public Work.WorkBuilder hours(double hours) {
            this.hours = hours;
            return this;
        }

        public Work.WorkBuilder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Work.WorkBuilder issue(Issues issue) {
            this.issue = issue;
            return this;
        }

        public Work.WorkBuilder workType(WorkType workType) {
            this.workType = workType;
            return this;
        }

        public Work.WorkBuilder user(Users user) {
            this.user = user;
            return this;
        }

        public Work build() {
            return new Work(idWork, time, hours, comment, issue, workType, user);
        }

        public String toString() {
            return "Work.WorkBuilder(idWork=" + this.idWork + ", time=" + this.time + ", hours=" + this.hours + ", comment=" + this.comment + ", issue=" + this.issue + ", workType=" + this.workType + ", user=" + this.user + ")";
        }
    }
}
