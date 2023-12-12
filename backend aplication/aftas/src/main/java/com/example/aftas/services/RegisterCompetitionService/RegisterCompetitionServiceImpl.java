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
    public Ranking saveRegestration(Ranking entityDTO,Long memberId,Long compId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Competition> competition = competitionRepository.findById(compId);
        entityDTO.setMember(member.get());
        entityDTO.setCompetition(competition.get());

        Ranking ranking = rankingRepository.save(entityDTO);
        return ranking;
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
