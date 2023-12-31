package com.example.aftas.repositories;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository  extends JpaRepository<Level, Long> {
    @Query("SELECT l FROM Level l WHERE l.code = :code")
    Optional<Level> getLevelByCode(Integer code);
}
