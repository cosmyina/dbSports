package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import ro.db.appl.domain.Competition;
import ro.db.appl.domain.Race;

import java.util.List;

public interface RaceService {

    Race save(Race race);
    Race remove(Long id);
    List<Race> findAll();
    List<Race> findAll(Pageable pageable);
    Race findById(Long id);

}
