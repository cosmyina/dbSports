package ro.db.appl.resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.Competitor;
import ro.db.appl.domain.Registration;
import ro.db.appl.email.EmailImpl;
import ro.db.appl.service.RegistrationService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationResource {

    private final RegistrationService registrationService;

    @Inject
    public RegistrationResource(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        Competitor competitor = this.registrationService.findByRegistration(registration.getCompetitor().getId());
        System.out.println("!!!!!!!!" + competitor.toString());
        System.out.println(registration.toString());
        System.out.println("!!!!!!!!!!!!!" + registration.getCompetitor().getId() );

        String[] to = { competitor.getEmail() }; // list of recipient email addresses
        String subject = "Inregistrare competitie noua";
        String body = "Hi " + competitor.getFirstName() + ", \n Have a nice day!";
        EmailImpl email = new EmailImpl();
        email.sendFromGMail(email.getFrom(), email.getPass(), to, subject, body);

        return this.registrationService.save(registration);
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        return this.registrationService.save(registration);
    }

    @DeleteMapping("/{id}")
    public Registration remove(@PathVariable("id") Long id) {
        return this.registrationService.remove(id);
    }

    @GetMapping
    public List<Registration> findAll() {
        return this.registrationService.findAll();
    }

    @GetMapping("/{start}/{rows}")
    public List<Registration> findAll(@PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.registrationService.findAll(PageRequest.of(start, rows));
    }

    @GetMapping("/{id}")
    public Registration findById(@PathVariable("id") Long id) {
        return this.registrationService.findById(id);
    }

}
