package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import ro.db.appl.domain.Competition;

import java.util.List;

public interface CompetitionService {

    Competition save(Competition competition);
    Competition remove(Long id);
    List<Competition> findAll();
    List<Competition> findAll(Pageable pageable);
    Competition findById(Long id);

}
