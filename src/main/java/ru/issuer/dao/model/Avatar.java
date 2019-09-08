package ru.issuer.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "avatar", schema = "public", catalog = "cdissuer")
public class Avatar {
    private int idAvatar;
    private Timestamp loadTime;
    private String pathFull;
    private String pathMin;
    private String pathMed;
    private Users userLoaded;

    public Avatar() {
    }

    public Avatar(int idAvatar, Timestamp loadTime, String pathFull, String pathMin, String pathMed, Users userLoaded) {
        this.idAvatar = idAvatar;
        this.loadTime = loadTime;
        this.pathFull = pathFull;
        this.pathMin = pathMin;
        this.pathMed = pathMed;
        this.userLoaded = userLoaded;
    }

    public static AvatarBuilder builder() {
        return new AvatarBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avatar", nullable = false)
    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    @Basic
    @Column(name = "load_time", nullable = false)
    public Timestamp getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Timestamp loadTime) {
        this.loadTime = loadTime;
    }

    @Basic
    @Column(name = "path_full", nullable = false, length = 500)
    public String getPathFull() {
        return pathFull;
    }

    public void setPathFull(String pathFull) {
        this.pathFull = pathFull;
    }

    @Basic
    @Column(name = "path_min", nullable = true, length = 500)
    public String getPathMin() {
        return pathMin;
    }

    public void setPathMin(String pathMin) {
        this.pathMin = pathMin;
    }

    @Basic
    @Column(name = "path_med", nullable = true, length = 500)
    public String getPathMed() {
        return pathMed;
    }

    public void setPathMed(String pathMed) {
        this.pathMed = pathMed;
    }


    @OneToOne
    @JoinColumn(name = "user_loaded", referencedColumnName = "id_user")
    public Users getUserLoaded() {
        return userLoaded;
    }

    public void setUserLoaded(Users userLoaded) {
        this.userLoaded = userLoaded;
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Avatar)) return false;
        final Avatar other = (Avatar) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdAvatar() != other.getIdAvatar()) return false;
        final Object this$loadTime = this.getLoadTime();
        final Object other$loadTime = other.getLoadTime();
        if (this$loadTime == null ? other$loadTime != null : !this$loadTime.equals(other$loadTime)) return false;
        final Object this$pathFull = this.getPathFull();
        final Object other$pathFull = other.getPathFull();
        if (this$pathFull == null ? other$pathFull != null : !this$pathFull.equals(other$pathFull)) return false;
        final Object this$pathMin = this.getPathMin();
        final Object other$pathMin = other.getPathMin();
        if (this$pathMin == null ? other$pathMin != null : !this$pathMin.equals(other$pathMin)) return false;
        final Object this$pathMed = this.getPathMed();
        final Object other$pathMed = other.getPathMed();
        if (this$pathMed == null ? other$pathMed != null : !this$pathMed.equals(other$pathMed)) return false;
        final Object this$userLoaded = this.getUserLoaded();
        final Object other$userLoaded = other.getUserLoaded();
        if (this$userLoaded == null ? other$userLoaded != null : !this$userLoaded.equals(other$userLoaded))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Avatar;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdAvatar();
        final Object $loadTime = this.getLoadTime();
        result = result * PRIME + ($loadTime == null ? 43 : $loadTime.hashCode());
        final Object $pathFull = this.getPathFull();
        result = result * PRIME + ($pathFull == null ? 43 : $pathFull.hashCode());
        final Object $pathMin = this.getPathMin();
        result = result * PRIME + ($pathMin == null ? 43 : $pathMin.hashCode());
        final Object $pathMed = this.getPathMed();
        result = result * PRIME + ($pathMed == null ? 43 : $pathMed.hashCode());
        final Object $userLoaded = this.getUserLoaded();
        result = result * PRIME + ($userLoaded == null ? 43 : $userLoaded.hashCode());
        return result;
    }

    public String toString() {
        return "Avatar(idAvatar=" + this.getIdAvatar() + ", loadTime=" + this.getLoadTime() + ", pathFull=" + this.getPathFull() + ", pathMin=" + this.getPathMin() + ", pathMed=" + this.getPathMed() + ", userLoaded=" + this.getUserLoaded() + ")";
    }

    public static class AvatarBuilder {
        private int idAvatar;
        private Timestamp loadTime;
        private String pathFull;
        private String pathMin;
        private String pathMed;
        private Users userLoaded;

        AvatarBuilder() {
        }

        public Avatar.AvatarBuilder idAvatar(int idAvatar) {
            this.idAvatar = idAvatar;
            return this;
        }

        public Avatar.AvatarBuilder loadTime(Timestamp loadTime) {
            this.loadTime = loadTime;
            return this;
        }

        public Avatar.AvatarBuilder pathFull(String pathFull) {
            this.pathFull = pathFull;
            return this;
        }

        public Avatar.AvatarBuilder pathMin(String pathMin) {
            this.pathMin = pathMin;
            return this;
        }

        public Avatar.AvatarBuilder pathMed(String pathMed) {
            this.pathMed = pathMed;
            return this;
        }

        public Avatar.AvatarBuilder userLoaded(Users userLoaded) {
            this.userLoaded = userLoaded;
            return this;
        }

        public Avatar build() {
            return new Avatar(idAvatar, loadTime, pathFull, pathMin, pathMed, userLoaded);
        }

        public String toString() {
            return "Avatar.AvatarBuilder(idAvatar=" + this.idAvatar + ", loadTime=" + this.loadTime + ", pathFull=" + this.pathFull + ", pathMin=" + this.pathMin + ", pathMed=" + this.pathMed + ", userLoaded=" + this.userLoaded + ")";
        }
    }
}
