package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.db.appl.domain.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
