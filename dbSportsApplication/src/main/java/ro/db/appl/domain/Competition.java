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

    @Column(name = "day")
    private Long day;

    @Column(name = "month")
    private String month;

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

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
                ", day=" + day +
                ", month='" + month + '\'' +
                ", category=" + category +
                '}';
    }

    public static final class CompetitionBuilder {

        private Long id;
        private String name;
        private String place;
        private Long day;
        private String month;
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

        public CompetitionBuilder withDay(Long day) {
            this.day = day;
            return this;
        }

        public CompetitionBuilder withMonth(String month) {
            this.month = month;
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
            competition.setDay(day);
            competition.setMonth(month);
            competition.setCategory(category);
            return competition;
        }

    }

}
