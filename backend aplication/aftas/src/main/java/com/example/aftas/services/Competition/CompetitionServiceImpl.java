package com.example.aftas.services.Competition;

import com.example.aftas.entities.Competition;
import com.example.aftas.repositories.CompetitionRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Competition save(Competition competition) {
        // Check if the competition date is in the past
        if (competition.getDate() != null && competition.getDate().before(new Date())) {
            throw new IllegalArgumentException("Competition date cannot be in the past");
        }

        // Check if there is already a competition on the same date
        if (competition.getDate() != null && competitionRepository.existsByDate(competition.getDate())) {
            throw new IllegalArgumentException("Another competition already exists on the same date");
        }

        // Generate the competition code
        competition.generateCode();

        // Save the competition if validation passes
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
