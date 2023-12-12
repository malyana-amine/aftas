package com.example.aftas.services.Competition;

import com.example.aftas.entities.Competition;
import com.example.aftas.repositories.CompetitionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompetitionServiceImpl implements CompetitionService {

    private CompetitionRepository competitionRepository;


    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
    @Override
    public List<Competition> findAll() {
        return null;
    }

    @Override
    public Optional<Competition> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition update(Competition entityDTO) {
        return null;
    }

    @Override
    public Optional<Competition> delete(Long aLong) {
        return Optional.empty();
    }
}
