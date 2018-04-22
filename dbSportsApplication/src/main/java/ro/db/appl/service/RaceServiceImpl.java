package ro.db.appl.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Race;
import ro.db.appl.repository.RaceRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;

    @Inject
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Transactional
    public Race save(Race race) {
        return this.raceRepository.save(race);
    }

    @Transactional
    public Race remove(Long id) {
        Race race = this.raceRepository.findById(id).orElse(null);
        if(race != null) {
            this.raceRepository.delete(race);
        }
        return race;
    }

    @Override
    public List<Race> findAll() {
        Stream<Race> stream = this.raceRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Race> findAll(Pageable pageable) {
        Stream<Race> stream = this.raceRepository.findAll(pageable).stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public Race findById(Long id) {
        Optional<Race> race = this.raceRepository.findById(id);
        return race.orElse(null);
    }
}
