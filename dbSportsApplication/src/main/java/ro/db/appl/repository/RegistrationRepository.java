package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.db.appl.domain.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
