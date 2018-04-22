package ro.db.appl.resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.Competitor;
import ro.db.appl.service.CompetitorService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/competitor")
public class CompetitorResource {

    private final CompetitorService competitorService;

    @Inject
    public CompetitorResource(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @PostMapping
    public Competitor create(@RequestBody Competitor competitor) {
        return this.competitorService.save(competitor);
    }

    @PutMapping
    public Competitor update(@RequestBody Competitor competitor) {
        return this.competitorService.save(competitor);
    }

    @DeleteMapping("/{id}")
    public Competitor remove(@PathVariable("id") Long id) {
        return this.competitorService.remove(id);
    }

    @GetMapping
    public List<Competitor> findAll() {
        return this.competitorService.findAll();
    }

    @GetMapping("/{start}/{rows}")
    public List<Competitor> findAll(@PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.competitorService.findAll(PageRequest.of(start, rows));
    }

    @GetMapping("/{id}")
    public Competitor findById(@PathVariable("id") Long id) {
        return this.competitorService.findById(id);
    }

}
