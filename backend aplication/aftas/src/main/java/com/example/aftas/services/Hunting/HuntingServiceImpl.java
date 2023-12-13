package com.example.aftas.services.Hunting;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Member;
import com.example.aftas.repositories.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class HuntingServiceImpl implements HuntingService {
    private FishRepository fishRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    private HuntingRepository huntingRepository;
    public HuntingServiceImpl(HuntingRepository huntingRepository, FishRepository fishRepository ,MemberRepository memberRepository,CompetitionRepository competitionRepository) {

        this.huntingRepository = huntingRepository;
        this.fishRepository = fishRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
    }
    @Override
    public List<Hunting> findAll() {
        return null;
    }
    @Override
    public Optional<Hunting> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Hunting save(Hunting entityDTO) {
        return null;
    }
    @Override
    public Hunting saveHunting(Long memberId, Long compId, Long fishId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Competition> competition = competitionRepository.findById(compId);
        Optional<Fish> fish = fishRepository.findById(fishId);
        Hunting hunting = new Hunting();
        hunting.setCompetition(competition.get());
        hunting.setFish(fish.get());
        hunting.setMember(member.get());

        return huntingRepository.save(hunting);
    }

    @Override
    public Hunting update(Hunting entityDTO) {
        return null;
    }

    @Override
    public Optional<Hunting> delete(Long aLong) {
        return Optional.empty();
    }
}
