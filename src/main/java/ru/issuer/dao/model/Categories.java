package ru.issuer.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "categories", schema = "public", catalog = "cdissuer")
public class Categories {
    private int idCategory;
    private String name;
    private Projects project;

    public Categories() {
    }

    public Categories(int idCategory, String name, Projects project) {
        this.idCategory = idCategory;
        this.name = name;
        this.project = project;
    }

    public static CategoriesBuilder builder() {
        return new CategoriesBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "id_project")
    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public String toString() {
        return "Categories(idCategory=" + this.getIdCategory() + ", name=" + this.getName() + ", project=" + this.getProject() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Categories)) return false;
        final Categories other = (Categories) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getIdCategory() != other.getIdCategory()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$project = this.getProject();
        final Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Categories;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIdCategory();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $project = this.getProject();
        result = result * PRIME + ($project == null ? 43 : $project.hashCode());
        return result;
    }


    public static class CategoriesBuilder {
        private int idCategory;
        private String name;
        private Projects project;

        CategoriesBuilder() {
        }

        public CategoriesBuilder idCategory(int idCategory) {
            this.idCategory = idCategory;
            return this;
        }

        public CategoriesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoriesBuilder project(Projects project) {
            this.project = project;
            return this;
        }

        public Categories build() {
            return new Categories(idCategory, name, project);
        }

        public String toString() {
            return "Categories.CategoriesBuilder(idCategory=" + this.idCategory + ", name=" + this.name + ", project=" + this.project + ")";
        }
    }
}
