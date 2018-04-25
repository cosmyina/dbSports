package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Competition;
import ro.db.appl.domain.Competitor;
import ro.db.appl.domain.Race;
import ro.db.appl.domain.Registration;
import ro.db.appl.repository.RegistrationRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Inject
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Transactional
    public Registration save(Registration registration) {
        return this.registrationRepository.save(registration);
    }

    @Transactional
    public Registration remove(Long id) {
        Registration registration = this.registrationRepository.findById(id).orElse(null);
        if(registration != null) {
            this.registrationRepository.delete(registration);
        }
        return registration;
    }

    @Override
    public List<Registration> findAll() {
        Stream<Registration> stream = this.registrationRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Registration> findAll(Pageable pageable) {
        Stream<Registration> stream = this.registrationRepository.findAll(pageable).stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public Registration findById(Long id) {
        Optional<Registration> registration = this.registrationRepository.findById(id);
        return registration.orElse(null);
    }

    public Competitor findByRegistration(Long id) {
        Optional<Competitor> competitor = Optional.ofNullable(this.registrationRepository.findByRegistration(id));
        return competitor.orElse(null);
    }

    public Registration findByCompetitionAndCompetitor(Competition competition, Competitor competitor){
        return this.registrationRepository.findByCompetitionAndCompetitor(competition, competitor);
    }

}
