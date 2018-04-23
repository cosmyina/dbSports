package ro.db.appl.domain;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "competition_id")
    private Long id;

    @Column(name = "competition_name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "category_id")
    private Category category;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", date=" + date +
                ", category=" + category +
                '}';
    }

    public static final class CompetitionBuilder {

        private Long id;
        private String name;
        private String place;
        private Date date;
        private Category category;

        private CompetitionBuilder() {
        }

        public static CompetitionBuilder get() {
            return new CompetitionBuilder();
        }

        public CompetitionBuilder withID(Long id) {
            this.id = id;
            return this;
        }

        public CompetitionBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CompetitionBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public CompetitionBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public CompetitionBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public Competition build() {
            Competition competition = new Competition();
            competition.setId(id);
            competition.setName(name);
            competition.setPlace(place);
            competition.setDate(date);
            competition.setCategory(category);
            return competition;
        }

    }

}
