package com.example.aftas.web.rest;

import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.entities.Competition;

import com.example.aftas.entities.Member;
import com.example.aftas.services.Competition.CompetitionService;
import com.example.aftas.services.EntityDTOConverterService;

import org.springframework.beans.factory.annotation.Qualifier;
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
    public ResponseEntity<CompetitionDTO> saveCompetition(@RequestBody Competition competition){
        Competition competition1 = competitionService.save(competition);
        CompetitionDTO competitionDTO = converterService.convertToDTO(competition1);
        return new ResponseEntity<>(competitionDTO, HttpStatus.OK);
    }
}
