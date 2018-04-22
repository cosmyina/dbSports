package ro.db.appl.resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.Competition;
import ro.db.appl.service.CompetitionService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/competition")
public class CompetitionResource {

    private final CompetitionService competitionService;

    @Inject
    public CompetitionResource(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    public Competition create(@RequestBody Competition competition) {
        return this.competitionService.save(competition);
    }

    @PutMapping
    public Competition update(@RequestBody Competition competition) {
        return this.competitionService.save(competition);
    }

    @DeleteMapping("/{id}")
    public Competition remove(@PathVariable("id") Long id) {
        return this.competitionService.remove(id);
    }

    @GetMapping
    public List<Competition> findAll() {
        return this.competitionService.findAll();
    }

    @GetMapping("/{start}/{rows}")
    public List<Competition> findAll(@PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.competitionService.findAll(PageRequest.of(start, rows));
    }

    @GetMapping("/{id}")
    public Competition findById(@PathVariable("id") Long id) {
        return this.competitionService.findById(id);
    }

}
