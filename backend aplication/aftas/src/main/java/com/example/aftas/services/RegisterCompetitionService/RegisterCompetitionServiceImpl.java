package com.example.aftas.services.RegisterCompetitionService;

import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import com.example.aftas.entities.embadded.MemberCompetition;
import com.example.aftas.repositories.CompetitionRepository;
import com.example.aftas.repositories.MemberRepository;
import com.example.aftas.repositories.RankingRepository;
import com.example.aftas.services.EntityDTOConverterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
@Component
public class RegisterCompetitionServiceImpl implements RegisterCompetitionService {
    private RankingRepository rankingRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    private final EntityDTOConverterService converterService;
    public RegisterCompetitionServiceImpl(RankingRepository rankingRepository, MemberRepository memberRepository, CompetitionRepository competitionRepository,@Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.rankingRepository = rankingRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
        this.converterService = converterService;
    }

    @Override
    public List<Ranking> findAll() {
        return null;
    }

    @Override
    public Optional<Ranking> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Ranking save(Ranking entityDTO) {
        return rankingRepository.save(entityDTO);
    }

    @Override
    public ResponseDTO saveRegestration(Ranking entityDTO, Long memberId, Long compId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Competition competition = competitionRepository.getById(compId);

        LocalDateTime now = LocalDateTime.now();
        Instant instant = competition.getDate().toInstant();
        LocalDateTime competitionEndTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .with(competition.getEndTime().toLocalTime());

        long hoursDifference = ChronoUnit.HOURS.between(now, competitionEndTime);
        if (hoursDifference < 24) {
            return new ResponseDTO("400","Registration is closed for this competition");
        }

        if(member.isEmpty()){
            return new ResponseDTO("400","this member is not found");
        }else {
            Ranking existingRegistration = rankingRepository.findByMemberAndCompetition(member.get(), competition);
            if (existingRegistration != null) {
                return new ResponseDTO("400","Member has already registered for this competition");
//   throw new RuntimeException("Member has already registered for this competition");
        }
            entityDTO.setMember(member.get());
            entityDTO.setCompetition(competition);

            entityDTO.setRank(999);
            entityDTO.setScore(0);
            entityDTO.setId(new MemberCompetition().builder()
                    .competitionId(competition.getId()).memberId(member.get().getId()).build());

            Ranking ranking = rankingRepository.save(entityDTO);

            return new ResponseDTO("200","register Member successfully",converterService.convertToDTO(ranking));
        }
    }




    @Override
    public Ranking update(Ranking entityDTO) {
        return null;
    }

    @Override
    public Optional<Ranking> delete(Long aLong) {
        return Optional.empty();
    }
}
