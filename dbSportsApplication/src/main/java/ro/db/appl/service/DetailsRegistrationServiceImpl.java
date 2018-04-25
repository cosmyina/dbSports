package ro.db.appl.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Competitor;
import ro.db.appl.domain.DetailsRegistration;
import ro.db.appl.domain.Registration;
import ro.db.appl.repository.CompetitorRepository;
import ro.db.appl.repository.DetailsRegistrationRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class DetailsRegistrationServiceImpl implements DetailsRegistrationService {

    private final DetailsRegistrationRepository detailsRegistrationRepository;
    private final CompetitorRepository competitorRepository;

    @Inject
    public DetailsRegistrationServiceImpl(DetailsRegistrationRepository detailsRegistrationRepository, CompetitorRepository competitorRepository) {
        this.detailsRegistrationRepository = detailsRegistrationRepository;
        this.competitorRepository = competitorRepository;
    }



    @Transactional
    public DetailsRegistration save(DetailsRegistration detailsRegistration) {
        return this.detailsRegistrationRepository.save(detailsRegistration);
    }

    @Transactional
    public DetailsRegistration remove(Long id) {
        DetailsRegistration detailsRegistration = this.detailsRegistrationRepository.findById(id).orElse(null);
        if(detailsRegistration != null) {
            this.detailsRegistrationRepository.delete(detailsRegistration);
        }
        return detailsRegistration;
    }

    @Override
    public List<DetailsRegistration> findAll() {
        Stream<DetailsRegistration> stream = this.detailsRegistrationRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    public Long findByEmail(String email) {
        Long id = this.detailsRegistrationRepository.findByEmail(email);
        return id;
    }

    public void insertCompetitor(String firstName, String lastName, String email, String gender, String size) {
        Competitor competitor = new Competitor();
        competitor.setFirstName(firstName);
        competitor.setLastName(lastName);
        competitor.setEmail(email);
        competitor.setGender(gender);
        competitor.setSize(size);
        this.competitorRepository.save(competitor);
    }




}
