package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "issues", schema = "public", catalog = "cdissuer")
public class Issues {
    private int idIssue;
    private String name;
    private String description;
    private Timestamp created;
    private Timestamp changed;
    private Double mark;
    private Date startTime;
    private Date endTime;
    private Integer progress;
    private Set<Actions> actions;
    private Set<Files> files;
    private Projects project;
    private Users createdUser;
    private Users performedUser;
    private Versions version;
    private Statuses status;
    private Trackers tracker;
    private Categories category;
    private Issues rootIssue;
    private Set<Issues> childIssues;
    private Set<Work> works;
    private Set<Subscriptions> subscribers;

    public Issues() {
    }

    public Issues(int idIssue, String name, String description, Timestamp created, Timestamp changed, Double mark, Date startTime, Date endTime, Integer progress, Set<Actions> actions, Set<Files> files, Projects project, Users createdUser, Users performedUser, Versions version, Statuses status, Trackers tracker, Categories category, Issues rootIssue, Set<Issues> childIssues, Set<Work> works, Set<Subscriptions> subscribers) {
        this.idIssue = idIssue;
        this.name = name;
        this.description = description;
        this.created = created;
        this.changed = changed;
        this.mark = mark;
        this.startTime = startTime;
        this.endTime = endTime;
        this.progress = progress;
        this.actions = actions;
        this.files = files;
        this.project = project;
        this.createdUser = createdUser;
        this.performedUser = performedUser;
        this.version = version;
        this.status = status;
        this.tracker = tracker;
        this.category = category;
        this.rootIssue = rootIssue;
        this.childIssues = childIssues;
        this.works = works;
        this.subscribers = subscribers;
    }

    public static IssuesBuilder builder() {
        return new IssuesBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_issue", nullable = false)
    public int getIdIssue() {
        return idIssue;
    }

    public void setIdIssue(int idIssue) {
        this.idIssue = idIssue;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "created", nullable = false)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "changed", nullable = false)
    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    @Basic
    @Column(name = "mark", nullable = true, precision = 0)
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "progress", nullable = true)
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }


    @OneToMany
    @JoinColumn(name = "id_issue")
    public Set<Actions> getActions() {
        return actions;
    }

    public void setActions(Set<Actions> actions) {
        this.actions = actions;
    }

    @OneToMany
    @JoinColumn(name = "id_issue")
    public Set<Files> getFiles() {
        return files;
    }

    public void setFiles(Set<Files> files) {
        this.files = files;
    }

    @ManyToOne
    @JoinColumn(name = "id_project")
    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "id_created", referencedColumnName = "id_user")
    public Users getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Users createdUser) {
        this.createdUser = createdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_version")
    public Versions getVersion() {
        return version;
    }

    public void setVersion(Versions version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "id_performed", referencedColumnName = "id_user")
    public Users getPerformedUser() {
        return performedUser;
    }

    public void setPerformedUser(Users performedUser) {
        this.performedUser = performedUser;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id_status")
    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "tracker_id", referencedColumnName = "id_tracker")
    public Trackers getTracker() {
        return tracker;
    }

    public void setTracker(Trackers tracker) {
        this.tracker = tracker;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id_category")
    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "parent_issue", referencedColumnName = "id_issue")
    public Issues getRootIssue() {
        return rootIssue;
    }

    public void setRootIssue(Issues rootIssue) {
        this.rootIssue = rootIssue;
    }

    @OneToMany
    @JoinColumn(name = "id_issue", referencedColumnName = "parent_issue")
    public Set<Issues> getChildIssues() {
        return childIssues;
    }

    public void setChildIssues(Set<Issues> childIssues) {
        this.childIssues = childIssues;
    }

    @OneToMany
    @JoinColumn(name = "id_issue")
    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @OneToMany
    @JoinColumn(name = "id_issue")
    public Set<Subscriptions> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriptions> subscribers) {
        this.subscribers = subscribers;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Issues)) return false;
        final Issues other = (Issues) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdIssue() != other.getIdIssue()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$changed = this.getChanged();
        final Object other$changed = other.getChanged();
        if (this$changed == null ? other$changed != null : !this$changed.equals(other$changed)) return false;
        final Object this$mark = this.getMark();
        final Object other$mark = other.getMark();
        if (this$mark == null ? other$mark != null : !this$mark.equals(other$mark)) return false;
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$progress = this.getProgress();
        final Object other$progress = other.getProgress();
        if (this$progress == null ? other$progress != null : !this$progress.equals(other$progress)) return false;
        final Object this$actions = this.getActions();
        final Object other$actions = other.getActions();
        if (this$actions == null ? other$actions != null : !this$actions.equals(other$actions)) return false;
        final Object this$files = this.getFiles();
        final Object other$files = other.getFiles();
        if (this$files == null ? other$files != null : !this$files.equals(other$files)) return false;
        final Object this$project = this.getProject();
        final Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) return false;
        final Object this$createdUser = this.getCreatedUser();
        final Object other$createdUser = other.getCreatedUser();
        if (this$createdUser == null ? other$createdUser != null : !this$createdUser.equals(other$createdUser))
            return false;
        final Object this$performedUser = this.getPerformedUser();
        final Object other$performedUser = other.getPerformedUser();
        if (this$performedUser == null ? other$performedUser != null : !this$performedUser.equals(other$performedUser))
            return false;
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$tracker = this.getTracker();
        final Object other$tracker = other.getTracker();
        if (this$tracker == null ? other$tracker != null : !this$tracker.equals(other$tracker)) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final Object this$rootIssue = this.getRootIssue();
        final Object other$rootIssue = other.getRootIssue();
        if (this$rootIssue == null ? other$rootIssue != null : !this$rootIssue.equals(other$rootIssue)) return false;
        final Object this$childIssues = this.getChildIssues();
        final Object other$childIssues = other.getChildIssues();
        if (this$childIssues == null ? other$childIssues != null : !this$childIssues.equals(other$childIssues))
            return false;
        final Object this$works = this.getWorks();
        final Object other$works = other.getWorks();
        if (this$works == null ? other$works != null : !this$works.equals(other$works)) return false;
        final Object this$subscribers = this.getSubscribers();
        final Object other$subscribers = other.getSubscribers();
        if (this$subscribers == null ? other$subscribers != null : !this$subscribers.equals(other$subscribers))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Issues;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdIssue();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $changed = this.getChanged();
        result = result * PRIME + ($changed == null ? 43 : $changed.hashCode());
        final Object $mark = this.getMark();
        result = result * PRIME + ($mark == null ? 43 : $mark.hashCode());
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $progress = this.getProgress();
        result = result * PRIME + ($progress == null ? 43 : $progress.hashCode());
        final Object $actions = this.getActions();
        result = result * PRIME + ($actions == null ? 43 : $actions.hashCode());
        final Object $files = this.getFiles();
        result = result * PRIME + ($files == null ? 43 : $files.hashCode());
        final Object $project = this.getProject();
        result = result * PRIME + ($project == null ? 43 : $project.hashCode());
        final Object $createdUser = this.getCreatedUser();
        result = result * PRIME + ($createdUser == null ? 43 : $createdUser.hashCode());
        final Object $performedUser = this.getPerformedUser();
        result = result * PRIME + ($performedUser == null ? 43 : $performedUser.hashCode());
        final Object $version = this.getVersion();
        result = result * PRIME + ($version == null ? 43 : $version.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $tracker = this.getTracker();
        result = result * PRIME + ($tracker == null ? 43 : $tracker.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $rootIssue = this.getRootIssue();
        result = result * PRIME + ($rootIssue == null ? 43 : $rootIssue.hashCode());
        final Object $childIssues = this.getChildIssues();
        result = result * PRIME + ($childIssues == null ? 43 : $childIssues.hashCode());
        final Object $works = this.getWorks();
        result = result * PRIME + ($works == null ? 43 : $works.hashCode());
        final Object $subscribers = this.getSubscribers();
        result = result * PRIME + ($subscribers == null ? 43 : $subscribers.hashCode());
        return result;
    }

    public String toString() {
        return "Issues(idIssue=" + this.getIdIssue() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", created=" + this.getCreated() + ", changed=" + this.getChanged() + ", mark=" + this.getMark() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", progress=" + this.getProgress() + ", actions=" + this.getActions() + ", files=" + this.getFiles() + ", project=" + this.getProject() + ", createdUser=" + this.getCreatedUser() + ", performedUser=" + this.getPerformedUser() + ", version=" + this.getVersion() + ", status=" + this.getStatus() + ", tracker=" + this.getTracker() + ", category=" + this.getCategory() + ", rootIssue=" + this.getRootIssue() + ", childIssues=" + this.getChildIssues() + ", works=" + this.getWorks() + ", subscribers=" + this.getSubscribers() + ")";
    }

    public static class IssuesBuilder {
        private int idIssue;
        private String name;
        private String description;
        private Timestamp created;
        private Timestamp changed;
        private Double mark;
        private Date startTime;
        private Date endTime;
        private Integer progress;
        private ArrayList<Actions> actions;
        private ArrayList<Files> files;
        private Projects project;
        private Users createdUser;
        private Users performedUser;
        private Versions version;
        private Statuses status;
        private Trackers tracker;
        private Categories category;
        private Issues rootIssue;
        private ArrayList<Issues> childIssues;
        private ArrayList<Work> works;
        private ArrayList<Subscriptions> subscribers;

        IssuesBuilder() {
        }

        public Issues.IssuesBuilder idIssue(int idIssue) {
            this.idIssue = idIssue;
            return this;
        }

        public Issues.IssuesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Issues.IssuesBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Issues.IssuesBuilder created(Timestamp created) {
            this.created = created;
            return this;
        }

        public Issues.IssuesBuilder changed(Timestamp changed) {
            this.changed = changed;
            return this;
        }

        public Issues.IssuesBuilder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Issues.IssuesBuilder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Issues.IssuesBuilder endTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public Issues.IssuesBuilder progress(Integer progress) {
            this.progress = progress;
            return this;
        }

        public Issues.IssuesBuilder action(Actions action) {
            if (this.actions == null) this.actions = new ArrayList<Actions>();
            this.actions.add(action);
            return this;
        }

        public Issues.IssuesBuilder actions(Collection<? extends Actions> actions) {
            if (this.actions == null) this.actions = new ArrayList<Actions>();
            this.actions.addAll(actions);
            return this;
        }

        public Issues.IssuesBuilder clearActions() {
            if (this.actions != null)
                this.actions.clear();

            return this;
        }

        public Issues.IssuesBuilder file(Files file) {
            if (this.files == null) this.files = new ArrayList<Files>();
            this.files.add(file);
            return this;
        }

        public Issues.IssuesBuilder files(Collection<? extends Files> files) {
            if (this.files == null) this.files = new ArrayList<Files>();
            this.files.addAll(files);
            return this;
        }

        public Issues.IssuesBuilder clearFiles() {
            if (this.files != null)
                this.files.clear();

            return this;
        }

        public Issues.IssuesBuilder project(Projects project) {
            this.project = project;
            return this;
        }

        public Issues.IssuesBuilder createdUser(Users createdUser) {
            this.createdUser = createdUser;
            return this;
        }

        public Issues.IssuesBuilder performedUser(Users performedUser) {
            this.performedUser = performedUser;
            return this;
        }

        public Issues.IssuesBuilder version(Versions version) {
            this.version = version;
            return this;
        }

        public Issues.IssuesBuilder status(Statuses status) {
            this.status = status;
            return this;
        }

        public Issues.IssuesBuilder tracker(Trackers tracker) {
            this.tracker = tracker;
            return this;
        }

        public Issues.IssuesBuilder category(Categories category) {
            this.category = category;
            return this;
        }

        public Issues.IssuesBuilder rootIssue(Issues rootIssue) {
            this.rootIssue = rootIssue;
            return this;
        }

        public Issues.IssuesBuilder childIssue(Issues childIssue) {
            if (this.childIssues == null) this.childIssues = new ArrayList<Issues>();
            this.childIssues.add(childIssue);
            return this;
        }

        public Issues.IssuesBuilder childIssues(Collection<? extends Issues> childIssues) {
            if (this.childIssues == null) this.childIssues = new ArrayList<Issues>();
            this.childIssues.addAll(childIssues);
            return this;
        }

        public Issues.IssuesBuilder clearChildIssues() {
            if (this.childIssues != null)
                this.childIssues.clear();

            return this;
        }

        public Issues.IssuesBuilder work(Work work) {
            if (this.works == null) this.works = new ArrayList<Work>();
            this.works.add(work);
            return this;
        }

        public Issues.IssuesBuilder works(Collection<? extends Work> works) {
            if (this.works == null) this.works = new ArrayList<Work>();
            this.works.addAll(works);
            return this;
        }

        public Issues.IssuesBuilder clearWorks() {
            if (this.works != null)
                this.works.clear();

            return this;
        }

        public Issues.IssuesBuilder subscriber(Subscriptions subscriber) {
            if (this.subscribers == null) this.subscribers = new ArrayList<Subscriptions>();
            this.subscribers.add(subscriber);
            return this;
        }

        public Issues.IssuesBuilder subscribers(Collection<? extends Subscriptions> subscribers) {
            if (this.subscribers == null) this.subscribers = new ArrayList<Subscriptions>();
            this.subscribers.addAll(subscribers);
            return this;
        }

        public Issues.IssuesBuilder clearSubscribers() {
            if (this.subscribers != null)
                this.subscribers.clear();

            return this;
        }

        public Issues build() {
            Set<Actions> actions;
            switch (this.actions == null ? 0 : this.actions.size()) {
                case 0:
                    actions = java.util.Collections.emptySet();
                    break;
                case 1:
                    actions = java.util.Collections.singleton(this.actions.get(0));
                    break;
                default:
                    actions = new java.util.LinkedHashSet<Actions>(this.actions.size() < 1073741824 ? 1 + this.actions.size() + (this.actions.size() - 3) / 3 : Integer.MAX_VALUE);
                    actions.addAll(this.actions);
                    actions = java.util.Collections.unmodifiableSet(actions);
            }
            Set<Files> files;
            switch (this.files == null ? 0 : this.files.size()) {
                case 0:
                    files = java.util.Collections.emptySet();
                    break;
                case 1:
                    files = java.util.Collections.singleton(this.files.get(0));
                    break;
                default:
                    files = new java.util.LinkedHashSet<Files>(this.files.size() < 1073741824 ? 1 + this.files.size() + (this.files.size() - 3) / 3 : Integer.MAX_VALUE);
                    files.addAll(this.files);
                    files = java.util.Collections.unmodifiableSet(files);
            }
            Set<Issues> childIssues;
            switch (this.childIssues == null ? 0 : this.childIssues.size()) {
                case 0:
                    childIssues = java.util.Collections.emptySet();
                    break;
                case 1:
                    childIssues = java.util.Collections.singleton(this.childIssues.get(0));
                    break;
                default:
                    childIssues = new java.util.LinkedHashSet<Issues>(this.childIssues.size() < 1073741824 ? 1 + this.childIssues.size() + (this.childIssues.size() - 3) / 3 : Integer.MAX_VALUE);
                    childIssues.addAll(this.childIssues);
                    childIssues = java.util.Collections.unmodifiableSet(childIssues);
            }
            Set<Work> works;
            switch (this.works == null ? 0 : this.works.size()) {
                case 0:
                    works = java.util.Collections.emptySet();
                    break;
                case 1:
                    works = java.util.Collections.singleton(this.works.get(0));
                    break;
                default:
                    works = new java.util.LinkedHashSet<Work>(this.works.size() < 1073741824 ? 1 + this.works.size() + (this.works.size() - 3) / 3 : Integer.MAX_VALUE);
                    works.addAll(this.works);
                    works = java.util.Collections.unmodifiableSet(works);
            }
            Set<Subscriptions> subscribers;
            switch (this.subscribers == null ? 0 : this.subscribers.size()) {
                case 0:
                    subscribers = java.util.Collections.emptySet();
                    break;
                case 1:
                    subscribers = java.util.Collections.singleton(this.subscribers.get(0));
                    break;
                default:
                    subscribers = new java.util.LinkedHashSet<Subscriptions>(this.subscribers.size() < 1073741824 ? 1 + this.subscribers.size() + (this.subscribers.size() - 3) / 3 : Integer.MAX_VALUE);
                    subscribers.addAll(this.subscribers);
                    subscribers = java.util.Collections.unmodifiableSet(subscribers);
            }

            return new Issues(idIssue, name, description, created, changed, mark, startTime, endTime, progress, actions, files, project, createdUser, performedUser, version, status, tracker, category, rootIssue, childIssues, works, subscribers);
        }

        public String toString() {
            return "Issues.IssuesBuilder(idIssue=" + this.idIssue + ", name=" + this.name + ", description=" + this.description + ", created=" + this.created + ", changed=" + this.changed + ", mark=" + this.mark + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", progress=" + this.progress + ", actions=" + this.actions + ", files=" + this.files + ", project=" + this.project + ", createdUser=" + this.createdUser + ", performedUser=" + this.performedUser + ", version=" + this.version + ", status=" + this.status + ", tracker=" + this.tracker + ", category=" + this.category + ", rootIssue=" + this.rootIssue + ", childIssues=" + this.childIssues + ", works=" + this.works + ", subscribers=" + this.subscribers + ")";
        }
    }
}
