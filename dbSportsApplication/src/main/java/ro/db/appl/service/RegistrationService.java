package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import ro.db.appl.domain.Competitor;
import ro.db.appl.domain.Registration;

import java.util.List;

public interface RegistrationService {

    Registration save(Registration registration);
    Registration remove(Long id);
    List<Registration> findAll();
    List<Registration> findAll(Pageable pageable);
    Registration findById(Long id);

    Competitor findByRegistration(Long id);
}
