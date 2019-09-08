package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "trackers", schema = "public", catalog = "cdissuer")
public class Trackers {
    private int idTracker;
    private String name;

    public Trackers() {
    }

    public Trackers(int idTracker, String name) {
        this.idTracker = idTracker;
        this.name = name;
    }

    public static TrackersBuilder builder() {
        return new TrackersBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tracker", nullable = false)
    public int getIdTracker() {
        return idTracker;
    }

    public void setIdTracker(int idTracker) {
        this.idTracker = idTracker;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Trackers)) return false;
        final Trackers other = (Trackers) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdTracker() != other.getIdTracker()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Trackers;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdTracker();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "Trackers(idTracker=" + this.getIdTracker() + ", name=" + this.getName() + ")";
    }

    public static class TrackersBuilder {
        private int idTracker;
        private String name;

        TrackersBuilder() {
        }

        public Trackers.TrackersBuilder idTracker(int idTracker) {
            this.idTracker = idTracker;
            return this;
        }

        public Trackers.TrackersBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Trackers build() {
            return new Trackers(idTracker, name);
        }

        public String toString() {
            return "Trackers.TrackersBuilder(idTracker=" + this.idTracker + ", name=" + this.name + ")";
        }
    }
}
