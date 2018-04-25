package ro.db.appl.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.*;
import ro.db.appl.service.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/detailsRegistration")
public class DetailsRegistrationResource {

    private final DetailsRegistrationService detailsRegistrationService;

    private final RegistrationService registrationService;

    private final CompetitorService competitorService;

    private final CompetitionService competitionService;


    @Inject
    public DetailsRegistrationResource(DetailsRegistrationService detailsRegistrationService, CompetitorService competitorService, RegistrationService registrationService, CompetitionService competitionService, RaceService raceService) {
        this.detailsRegistrationService = detailsRegistrationService;
        this.competitorService = competitorService;
        this.registrationService = registrationService;
        this.competitionService = competitionService;
    }

    @PostMapping
    public HttpStatus create(@RequestBody DetailsRegistration detailsRegistration) {
        Long idCompetitor;
        idCompetitor = this.detailsRegistrationService.findByEmail(detailsRegistration.getEmail());

        if(idCompetitor != null) {
            System.out.println(idCompetitor);
        } else {
            this.detailsRegistrationService.insertCompetitor(detailsRegistration.getFirstName(), detailsRegistration.getLastName(), detailsRegistration.getEmail(), detailsRegistration.getGender(), detailsRegistration.getSize());
            idCompetitor = this.detailsRegistrationService.findByEmail(detailsRegistration.getEmail());
            System.out.println(idCompetitor);
        }


        if(registrationService.findByCompetitionAndCompetitor(
                competitionService.findById(detailsRegistration.getEventId()),
                competitorService.findById(idCompetitor))!=null){

            return HttpStatus.ALREADY_REPORTED;
        }
        Registration registration = new Registration();
        registration.setCompetition(competitionService.findById(detailsRegistration.getEventId()));
        registration.setCompetitor(competitorService.findById(idCompetitor));
        registrationService.save(registration);
        System.out.println(registration);
        if(detailsRegistrationService.save(detailsRegistration)!=null){
            return HttpStatus.CREATED;
        }
        return HttpStatus.BAD_REQUEST;

    }

    @DeleteMapping("/{id}")
    public DetailsRegistration remove(@PathVariable("id") Long id) {
        return this.detailsRegistrationService.remove(id);
    }

    @GetMapping
    public List<DetailsRegistration> findAll() {
        return this.detailsRegistrationService.findAll();
    }


}
