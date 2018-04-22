package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.db.appl.domain.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
