package com.example.aftas.services.Competition;

import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.MemberScoreDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.repositories.CompetitionRepository;
import com.example.aftas.repositories.RankingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompetitionServiceImpl implements CompetitionService {

    private CompetitionRepository competitionRepository;
    private final RankingRepository rankingRepository;
    private final ModelMapper modelMapper;


    public CompetitionServiceImpl(CompetitionRepository competitionRepository, RankingRepository rankingRepository, ModelMapper modelMapper) {
        this.competitionRepository = competitionRepository;
        this.rankingRepository = rankingRepository;
        this.modelMapper = modelMapper;
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
    public CompetitionDTO getById(Long id) {
        Competition competition = competitionRepository.getById(id);

        // Map Competition to CompetitionDTO
        CompetitionDTO competitionDTO = modelMapper.map(competition, CompetitionDTO.class);

        // Extract member scores from the associated Ranking entities
        List<MemberScoreDTO> memberScores = rankingRepository.findByCompetitionId(id).stream()
                .map(ranking -> {
                    MemberScoreDTO scoreDTO = new MemberScoreDTO();
                    scoreDTO.setMemberId(ranking.getMember().getId());
                    scoreDTO.setMemberName(ranking.getMember().getName());
                    scoreDTO.setScore(Double.valueOf(ranking.getScore()));
                    return scoreDTO;
                })
                .collect(Collectors.toList());

        // Set memberScores in the CompetitionDTO
        competitionDTO.setMemberScores(memberScores);

        return competitionDTO;
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
