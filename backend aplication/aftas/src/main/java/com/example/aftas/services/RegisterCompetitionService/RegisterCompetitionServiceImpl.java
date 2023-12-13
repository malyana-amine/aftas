package com.example.aftas.services.RegisterCompetitionService;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import com.example.aftas.repositories.CompetitionRepository;
import com.example.aftas.repositories.MemberRepository;
import com.example.aftas.repositories.RankingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RegisterCompetitionServiceImpl implements RegisterCompetitionService {
    private RankingRepository rankingRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    public RegisterCompetitionServiceImpl(RankingRepository rankingRepository,MemberRepository memberRepository,CompetitionRepository competitionRepository) {
        this.rankingRepository = rankingRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
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
    public Ranking saveRegestration(Ranking entityDTO, Long memberId, Long compId) {
        Member member = memberRepository.getById(memberId);
        Competition competition = competitionRepository.getById(compId);

        Ranking existingRegistration = rankingRepository.findByMemberAndCompetition(member, competition);
        if (existingRegistration != null) {
            throw new RuntimeException("Member has already registered for this competition");
        }

        entityDTO.setMember(member);
        entityDTO.setCompetition(competition);

        return rankingRepository.save(entityDTO);
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
