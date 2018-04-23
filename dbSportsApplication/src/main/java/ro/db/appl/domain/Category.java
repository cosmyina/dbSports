package ro.db.appl.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static final class CategoryBuilder {

        private Long id;
        private String name;

        private CategoryBuilder() {
        }

        public static CategoryBuilder get() {
            return new CategoryBuilder();
        }

        public CategoryBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder whitName(String name) {
            this.name = name;
            return this;
        }

        public Category build() {
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            return category;
        }

    }

}
