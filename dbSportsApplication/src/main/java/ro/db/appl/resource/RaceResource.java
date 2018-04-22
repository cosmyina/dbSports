package ro.db.appl.resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.Race;
import ro.db.appl.service.RaceService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceResource {

    private final RaceService raceService;

    @Inject
    public RaceResource(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping
    public Race create(@RequestBody Race race) {
        return this.raceService.save(race);
    }

    @PutMapping
    public Race update(@RequestBody Race race) {
        return this.raceService.save(race);
    }

    @DeleteMapping("/{id}")
    public Race remove(@PathVariable("id") Long id) {
        return this.raceService.remove(id);
    }

    @GetMapping
    public List<Race> findAll() {
        return this.raceService.findAll();
    }

    @GetMapping("/{start}/{rows}")
    public List<Race> findAll(@PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.raceService.findAll(PageRequest.of(start, rows));
    }

    @GetMapping("/{id}")
    public Race findById(@PathVariable("id") Long id) {
        return this.raceService.findById(id);
    }

}
