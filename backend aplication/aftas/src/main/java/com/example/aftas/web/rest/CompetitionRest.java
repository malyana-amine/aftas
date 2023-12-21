package com.example.aftas.web.rest;

import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Competition;

import com.example.aftas.services.Competition.CompetitionService;
import com.example.aftas.services.EntityDTOConverterService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competition")
public class CompetitionRest {
    private CompetitionService competitionService;
    private EntityDTOConverterService converterService;

    public CompetitionRest(CompetitionService competitionService, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.competitionService = competitionService;
        this.converterService = converterService;
    }

    @GetMapping("")
    public ResponseEntity<List<CompetitionDTO>> getAllCompetition() {
        List<Competition> competitions = competitionService.findAll();
        List<CompetitionDTO> competitionDTO = converterService.convertToDTO1(competitions);
        return new ResponseEntity<>(competitionDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionDTO> getCompetitionById(@PathVariable Long id) {
        CompetitionDTO competitionDTO = competitionService.getById(id);
        return new ResponseEntity<>(competitionDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> saveCompetition(@RequestBody Competition competition){
        ResponseDTO competition1 = competitionService.saveCompetition(competition);

        return new ResponseEntity<>(competition1, HttpStatus.OK);
    }
    @GetMapping("/paged")
    public ResponseEntity<Page<CompetitionDTO>> getAllCompetitionsPaged(Pageable pageable) {
        Page<CompetitionDTO> competitions = competitionService.findAllCompetitions(pageable);
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }
}
