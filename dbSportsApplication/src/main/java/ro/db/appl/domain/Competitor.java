package ro.db.appl.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "competitors")
public class Competitor {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "competitor_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "size")
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public static final class CompetitorBuilder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String gender;
        private String size;

        private CompetitorBuilder() {
        }

        public static CompetitorBuilder get() {
            return new CompetitorBuilder();
        }

        public CompetitorBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CompetitorBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CompetitorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CompetitorBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CompetitorBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public CompetitorBuilder withSize(String size) {
            this.size = size;
            return this;
        }

        public Competitor build() {
            Competitor competitor = new Competitor();
            competitor.setId(id);
            competitor.setFirstName(firstName);
            competitor.setLastName(lastName);
            competitor.setEmail(email);
            competitor.setGender(gender);
            competitor.setSize(size);
            return competitor;
        }

    }

}
