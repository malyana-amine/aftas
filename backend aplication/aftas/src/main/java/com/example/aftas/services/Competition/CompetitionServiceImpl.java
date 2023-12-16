package com.example.aftas.services.Competition;

import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.MemberScoreDTO;
import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.repositories.CompetitionRepository;
import com.example.aftas.repositories.RankingRepository;
import com.example.aftas.services.EntityDTOConverterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final EntityDTOConverterService converterService;


    public CompetitionServiceImpl(CompetitionRepository competitionRepository, RankingRepository rankingRepository, ModelMapper modelMapper,@Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.competitionRepository = competitionRepository;
        this.rankingRepository = rankingRepository;
        this.modelMapper = modelMapper;
        this.converterService = converterService;
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
    public Competition save(Competition entityDTO) {
        return null;
    }

    @Override
    public CompetitionDTO getById(Long id) {
        Competition competition = competitionRepository.getById(id);
        CompetitionDTO competitionDTO = modelMapper.map(competition, CompetitionDTO.class);
        List<MemberScoreDTO> memberScores = rankingRepository.findByCompetitionId(id).stream()
                .map(ranking -> {
                    MemberScoreDTO scoreDTO = new MemberScoreDTO();
                    scoreDTO.setMemberId(ranking.getMember().getId());
                    scoreDTO.setMemberName(ranking.getMember().getName());
                    scoreDTO.setScore(Double.valueOf(ranking.getScore()));
                    return scoreDTO;
                })
                .collect(Collectors.toList());
        competitionDTO.setMemberScores(memberScores);
        return competitionDTO;
    }

    @Override
    public ResponseDTO saveCompetition(Competition competition) {
        if (competition.getDate() != null && competition.getDate().before(new Date())) {
//            throw new IllegalArgumentException("Competition date cannot be in the past");
            return new ResponseDTO("400","Competition date cannot be in the past");
        }

        if (competition.getDate() != null && competitionRepository.existsByDate(competition.getDate())) {
            return new ResponseDTO("400","Another competition already exists on the same date");
//            throw new IllegalArgumentException("Another competition already exists on the same date");
        }

        competition.generateCode();
        Competition competition1 = competitionRepository.save(competition);


        return new ResponseDTO("200","add competition successful",converterService.convertToDTO(competition1));
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
