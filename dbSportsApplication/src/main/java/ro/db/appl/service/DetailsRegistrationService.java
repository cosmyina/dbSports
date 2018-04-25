package ro.db.appl.service;

import org.springframework.data.repository.query.Param;
import ro.db.appl.domain.DetailsRegistration;
import ro.db.appl.domain.Race;

import java.util.List;

public interface DetailsRegistrationService {

    DetailsRegistration save(DetailsRegistration detailsRegistration);
    DetailsRegistration remove(Long id);
    List<DetailsRegistration> findAll();

    Long findByEmail(String email);

    void insertCompetitor(String firstName, String lastName, String email, String gender, String size);




}
