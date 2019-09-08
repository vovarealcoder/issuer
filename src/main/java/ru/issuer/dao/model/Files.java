package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "files", schema = "public", catalog = "cdissuer")
public class Files {
    private int idFile;
    private String path;
    private String displayName;
    private Timestamp added;
    private Issues issue;
    private Users user;

    public Files() {
    }

    public Files(int idFile, String path, String displayName, Timestamp added, Issues issue, Users user) {
        this.idFile = idFile;
        this.path = path;
        this.displayName = displayName;
        this.added = added;
        this.issue = issue;
        this.user = user;
    }

    public static FilesBuilder builder() {
        return new FilesBuilder();
    }

    @Id
    @Column(name = "id_file", nullable = false)
    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    @Basic
    @Column(name = "path", nullable = false, length = 500)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "display_name", nullable = false, length = 500)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "added", nullable = false)
    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
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


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Files)) return false;
        final Files other = (Files) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdFile() != other.getIdFile()) return false;
        final Object this$path = this.getPath();
        final Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
        final Object this$displayName = this.getDisplayName();
        final Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName))
            return false;
        final Object this$added = this.getAdded();
        final Object other$added = other.getAdded();
        if (this$added == null ? other$added != null : !this$added.equals(other$added)) return false;
        final Object this$issue = this.getIssue();
        final Object other$issue = other.getIssue();
        if (this$issue == null ? other$issue != null : !this$issue.equals(other$issue)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Files;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdFile();
        final Object $path = this.getPath();
        result = result * PRIME + ($path == null ? 43 : $path.hashCode());
        final Object $displayName = this.getDisplayName();
        result = result * PRIME + ($displayName == null ? 43 : $displayName.hashCode());
        final Object $added = this.getAdded();
        result = result * PRIME + ($added == null ? 43 : $added.hashCode());
        final Object $issue = this.getIssue();
        result = result * PRIME + ($issue == null ? 43 : $issue.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Files(idFile=" + this.getIdFile() + ", path=" + this.getPath() + ", displayName=" + this.getDisplayName() + ", added=" + this.getAdded() + ", issue=" + this.getIssue() + ", user=" + this.getUser() + ")";
    }

    public static class FilesBuilder {
        private int idFile;
        private String path;
        private String displayName;
        private Timestamp added;
        private Issues issue;
        private Users user;

        FilesBuilder() {
        }

        public Files.FilesBuilder idFile(int idFile) {
            this.idFile = idFile;
            return this;
        }

        public Files.FilesBuilder path(String path) {
            this.path = path;
            return this;
        }

        public Files.FilesBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Files.FilesBuilder added(Timestamp added) {
            this.added = added;
            return this;
        }

        public Files.FilesBuilder issue(Issues issue) {
            this.issue = issue;
            return this;
        }

        public Files.FilesBuilder user(Users user) {
            this.user = user;
            return this;
        }

        public Files build() {
            return new Files(idFile, path, displayName, added, issue, user);
        }

        public String toString() {
            return "Files.FilesBuilder(idFile=" + this.idFile + ", path=" + this.path + ", displayName=" + this.displayName + ", added=" + this.added + ", issue=" + this.issue + ", user=" + this.user + ")";
        }
    }
}
