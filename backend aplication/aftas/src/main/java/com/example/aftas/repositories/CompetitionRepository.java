package com.example.aftas.repositories;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    boolean existsByDate(Date date);
}
