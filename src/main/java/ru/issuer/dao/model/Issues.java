package ru.issuer.dao.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Builder
@ToString
@EqualsAndHashCode
@Entity
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
    @Singular
    private Set<Actions> actions;
    @Singular
    private Set<Files> files;
    private Projects project;
    private Users createdUser;
    private Users performedUser;
    private Versions version;
    private Statuses status;
    private Trackers tracker;
    private Categories category;
    private Issues rootIssue;
    @Singular
    private Set<Issues> childIssues;
    @Singular
    private Set<Work> works;
    @Singular
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

    @Id
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

}
