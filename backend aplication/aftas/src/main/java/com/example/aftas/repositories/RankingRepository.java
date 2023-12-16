package com.example.aftas.repositories;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository  extends JpaRepository<Ranking, Long> {
    Ranking findByMemberAndCompetition(Member member, Competition competition);
    List<Ranking> findByCompetitionId(Long competitionId);
}
