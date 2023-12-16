package com.example.aftas.services.Hunting;

import com.example.aftas.entities.*;
import com.example.aftas.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class HuntingServiceImpl implements HuntingService {
    private FishRepository fishRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    private HuntingRepository huntingRepository;
    private final RankingRepository rankingRepository;
    public HuntingServiceImpl(HuntingRepository huntingRepository, FishRepository fishRepository , MemberRepository memberRepository, CompetitionRepository competitionRepository, RankingRepository rankingRepository) {
        this.huntingRepository = huntingRepository;
        this.fishRepository = fishRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
        this.rankingRepository = rankingRepository;
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
    public Hunting saveHunting(Long memberId, Long compId, Long fishId, Double actuelWeightOfHuntingFish) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Competition> competition = competitionRepository.findById(compId);
        Optional<Fish> fish = fishRepository.findById(fishId);

        if (fish.isPresent()) {
            Fish fishEntity = fish.get();

            if (actuelWeightOfHuntingFish < fishEntity.getAverageWeight()) {
                throw new IllegalArgumentException("Actual weight is less than average weight. Hunting record not saved.");
            }

            Optional<Hunting> existingHunt = huntingRepository.findByMemberAndFish(member.get(), fishEntity);
            Ranking existingRegistration = rankingRepository.findByMemberAndCompetition(member.get(), competition.get());

            if( existingRegistration == null ){
                throw new IllegalArgumentException("no member in this competition");
            }else
            if (existingHunt.isPresent()) {
                Hunting hunting = existingHunt.get();
                int currentCount = hunting.getNumberOfFish();
                hunting.setNumberOfFish(currentCount + 1);
                return huntingRepository.save(hunting);
            } else {
                Hunting hunting = new Hunting();
                hunting.setCompetition(competition.get());
                hunting.setFish(fishEntity);
                hunting.setMember(member.get());
                hunting.setNumberOfFish(1);
                return huntingRepository.save(hunting);
            }
        } else {
            // Handle the case when the fish entity is not present
            throw new EntityNotFoundException("Fish with id " + fishId + " not found. Hunting record not saved.");
        }
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
