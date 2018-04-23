package ro.db.appl.domain;

import javax.inject.Inject;
import javax.persistence.*;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "race_id")
    private Long id;

    @Column(name = "race_name")
    private String name;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "competition_id")
    private Competition competition;

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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", competition=" + competition +
                '}';
    }

    public static final class RaceBuilder {

        private Long id;
        private String name;
        private Competition competition;

        private RaceBuilder() {
        }

        public static RaceBuilder get() {
            return new RaceBuilder();
        }

        public RaceBuilder withID(Long id) {
            this.id = id;
            return this;
        }

        public RaceBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RaceBuilder withCompetition(Competition competition) {
            this.competition = competition;
            return this;
        }

        public Race build() {
            Race race = new Race();
            race.setId(id);
            race.setName(name);
            race.setCompetition(competition);
            return race;
        }

    }

}
