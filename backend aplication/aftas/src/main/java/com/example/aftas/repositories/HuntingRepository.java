package com.example.aftas.repositories;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HuntingRepository  extends JpaRepository<Hunting, Long> {
    Optional<Hunting> findByMemberAndFish(Member member, Fish fish);

    List<Hunting> findByMemberAndCompetition(Member member, Competition competition);
}
