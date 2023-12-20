package com.example.aftas.services.Hunting;

import com.example.aftas.DTO.HuntingDTO;
import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.*;
import com.example.aftas.repositories.*;
import com.example.aftas.services.EntityDTOConverterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final EntityDTOConverterService converterService;
    public HuntingServiceImpl(HuntingRepository huntingRepository, FishRepository fishRepository , MemberRepository memberRepository, CompetitionRepository competitionRepository, RankingRepository rankingRepository, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.huntingRepository = huntingRepository;
        this.fishRepository = fishRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
        this.rankingRepository = rankingRepository;
        this.converterService = converterService;
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
    public ResponseDTO saveHunting(Long memberId, Long compId, Long fishId, Double actuelWeightOfHuntingFish) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Competition> competition = competitionRepository.findById(compId);
        Optional<Fish> fish = fishRepository.findById(fishId);

        if(member.isEmpty()||competition.isEmpty()||fish.isEmpty()){
            return new ResponseDTO("400","fish or member or competition not found");
        }
        if (fish.isPresent()) {
            Fish fishEntity = fish.get();
            if (actuelWeightOfHuntingFish < fishEntity.getAverageWeight()) {
                return new ResponseDTO("400","Actual weight is less than average weight. Hunting record not saved.");
            }
            Optional<Hunting> existingHunt = huntingRepository.findByMemberAndFish(member.get(), fishEntity);
            Ranking existingRegistration = rankingRepository.findByMemberAndCompetition(member.get(), competition.get());
            Hunting hunting = new Hunting();
            if (existingRegistration == null) {
                return new ResponseDTO("400","No member in this competition");
            } else if (existingHunt.isPresent()) {
                int currentCount = existingHunt.get().getNumberOfFish();
                existingHunt.get().setNumberOfFish(currentCount + 1);
            } else {
                hunting.setCompetition(competition.get());
                hunting.setFish(fishEntity);
                hunting.setMember(member.get());
                hunting.setNumberOfFish(1);
            }
            Hunting hunting1 = huntingRepository.save(hunting);
            existingRegistration.setScore(existingRegistration.getScore()+fishEntity.getLevel().getPoint());
            updateRanks(competition.get());
            return new ResponseDTO("200","hunting saved",converterService.convertToDTO(hunting1));
        } else {
            return new ResponseDTO("400","fish not exist");
        }
    }

    private void updateRanks(Competition competition) {
        List<Ranking> rankings = rankingRepository.findByCompetitionOrderByScoreDesc(competition);
        int rank = 1;
        for (Ranking ranking : rankings) {
            ranking.setRank(rank++);
            rankingRepository.save(ranking);
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
