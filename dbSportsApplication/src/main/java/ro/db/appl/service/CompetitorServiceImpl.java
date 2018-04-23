package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Competitor;
import ro.db.appl.repository.CompetitorRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class CompetitorServiceImpl implements CompetitorService {

    private final CompetitorRepository competitorRepository;

    @Inject
    public CompetitorServiceImpl(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    @Transactional
    public Competitor save(Competitor competitor) {
        return this.competitorRepository.save(competitor);
    }

    @Transactional
    public Competitor remove(Long id) {
        Competitor competitor = this.competitorRepository.findById(id).orElse(null);
        if(competitor != null) {
            this.competitorRepository.delete(competitor);
        }
        return competitor;
    }

    @Override
    public List<Competitor> findAll() {
        Stream<Competitor> stream = this.competitorRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Competitor> findAll(Pageable pageable) {
        Stream<Competitor> stream = this.competitorRepository.findAll(pageable).stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public Competitor findById(Long id) {
        Optional<Competitor> competitor = this.competitorRepository.findById(id);
        return competitor.orElse(null);
    }
}
