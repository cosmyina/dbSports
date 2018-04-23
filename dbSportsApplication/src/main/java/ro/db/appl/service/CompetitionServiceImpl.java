package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Competition;
import ro.db.appl.repository.CompetitionRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Inject
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Transactional
    public Competition save(Competition competition) {
        return this.competitionRepository.save(competition);
    }

    @Transactional
    public Competition remove(Long id) {
        Competition competition = this.competitionRepository.findById(id).orElse(null);
        if(competition != null) {
            this.competitionRepository.delete(competition);
        }
        return competition;
    }

    @Override
    public List<Competition> findAll() {
        Stream<Competition> stream = this.competitionRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Competition> findAll(Pageable pageable) {
        Stream<Competition> stream = this.competitionRepository.findAll(pageable).stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public Competition findById(Long id) {
        Optional<Competition> byId = this.competitionRepository.findById(id);
        return byId.orElse(null);
    }
}
