package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "task_link", schema = "public", catalog = "cdissuer")
public class TaskLink {
    private int idLink;
    private Boolean copied;
    private Issues oneIssue;
    private Issues twoIssue;
    public TaskLink(int idLink, Boolean copied, Issues oneIssue, Issues twoIssue) {
        this.idLink = idLink;
        this.copied = copied;
        this.oneIssue = oneIssue;
        this.twoIssue = twoIssue;
    }

    public TaskLink() {
    }

    public static TaskLinkBuilder builder() {
        return new TaskLinkBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "two", referencedColumnName = "id_issue")
    public Issues getTwoIssue() {
        return twoIssue;
    }

    public void setTwoIssue(Issues twoIssue) {
        this.twoIssue = twoIssue;
    }

    @ManyToOne
    @JoinColumn(name = "one", referencedColumnName = "id_issue")
    public Issues getOneIssue() {
        return oneIssue;
    }

    public void setOneIssue(Issues oneIssue) {
        this.oneIssue = oneIssue;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskLink)) return false;
        final TaskLink other = (TaskLink) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdLink() != other.getIdLink()) return false;
        final Object this$copied = this.getCopied();
        final Object other$copied = other.getCopied();
        if (this$copied == null ? other$copied != null : !this$copied.equals(other$copied)) return false;
        final Object this$oneIssue = this.getOneIssue();
        final Object other$oneIssue = other.getOneIssue();
        if (this$oneIssue == null ? other$oneIssue != null : !this$oneIssue.equals(other$oneIssue)) return false;
        final Object this$twoIssue = this.getTwoIssue();
        final Object other$twoIssue = other.getTwoIssue();
        if (this$twoIssue == null ? other$twoIssue != null : !this$twoIssue.equals(other$twoIssue)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskLink;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdLink();
        final Object $copied = this.getCopied();
        result = result * PRIME + ($copied == null ? 43 : $copied.hashCode());
        final Object $oneIssue = this.getOneIssue();
        result = result * PRIME + ($oneIssue == null ? 43 : $oneIssue.hashCode());
        final Object $twoIssue = this.getTwoIssue();
        result = result * PRIME + ($twoIssue == null ? 43 : $twoIssue.hashCode());
        return result;
    }

    public String toString() {
        return "TaskLink(idLink=" + this.getIdLink() + ", copied=" + this.getCopied() + ", oneIssue=" + this.getOneIssue() + ", twoIssue=" + this.getTwoIssue() + ")";
    }

    public static class TaskLinkBuilder {
        private int idLink;
        private Boolean copied;
        private Issues oneIssue;
        private Issues twoIssue;

        TaskLinkBuilder() {
        }

        public TaskLink.TaskLinkBuilder idLink(int idLink) {
            this.idLink = idLink;
            return this;
        }

        public TaskLink.TaskLinkBuilder copied(Boolean copied) {
            this.copied = copied;
            return this;
        }

        public TaskLink.TaskLinkBuilder oneIssue(Issues oneIssue) {
            this.oneIssue = oneIssue;
            return this;
        }

        public TaskLink.TaskLinkBuilder twoIssue(Issues twoIssue) {
            this.twoIssue = twoIssue;
            return this;
        }

        public TaskLink build() {
            return new TaskLink(idLink, copied, oneIssue, twoIssue);
        }

        public String toString() {
            return "TaskLink.TaskLinkBuilder(idLink=" + this.idLink + ", copied=" + this.copied + ", oneIssue=" + this.oneIssue + ", twoIssue=" + this.twoIssue + ")";
        }
    }
}
