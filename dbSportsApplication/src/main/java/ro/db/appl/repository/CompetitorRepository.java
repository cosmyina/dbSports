package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.db.appl.domain.Competitor;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Long> {
}
