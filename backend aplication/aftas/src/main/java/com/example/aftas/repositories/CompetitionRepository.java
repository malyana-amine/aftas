package com.example.aftas.repositories;

import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
