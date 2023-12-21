package com.example.aftas.services.Competition;

import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CompetitionService extends CrudService<Competition,Long> {
    CompetitionDTO getById(Long aLong);

    ResponseDTO saveCompetition(Competition competition);

    Page<CompetitionDTO> findAllCompetitions(Pageable pageable);
}
