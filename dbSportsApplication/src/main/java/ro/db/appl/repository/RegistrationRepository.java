package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.db.appl.domain.Competition;
import ro.db.appl.domain.Competitor;
import ro.db.appl.domain.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("select co  from Competitor co where co.id = ?1")
    Competitor findByRegistration(Long id);

    Registration findByCompetitionAndCompetitor(Competition competition, Competitor competitor);

}
