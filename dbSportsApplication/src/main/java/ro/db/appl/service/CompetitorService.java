package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import ro.db.appl.domain.Competitor;

import java.util.List;

public interface CompetitorService {

    Competitor save(Competitor competitor);
    Competitor remove(Long id);
    List<Competitor> findAll();
    List<Competitor> findAll(Pageable pageable);
    Competitor findById(Long id);

}
