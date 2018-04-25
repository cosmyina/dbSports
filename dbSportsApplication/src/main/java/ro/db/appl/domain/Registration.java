package ro.db.appl.domain;

import javax.persistence.*;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "register_id")
    private Long id;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "competitor_id")
    private Competitor competitor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", competition=" + competition +
                ", competitor=" + competitor +
                '}';
    }

    public static final class RegistrationBuilder {

        private Long id;
        private Competition competition;
        private Competitor competitor;

        private RegistrationBuilder() {
        }

        public static RegistrationBuilder get() {
            return new RegistrationBuilder();
        }

        public RegistrationBuilder withID(Long id) {
            this.id = id;
            return this;
        }

        public RegistrationBuilder withCompetition(Competition competition) {
            this.competition = competition;
            return this;
        }


        public RegistrationBuilder withCompetitor(Competitor competitor) {
            this.competitor = competitor;
            return this;
        }

        public Registration build() {
            Registration registration = new Registration();
            registration.setId(id);
            registration.setCompetition(competition);
            registration.setCompetitor(competitor);
            return registration;
        }

    }


}
