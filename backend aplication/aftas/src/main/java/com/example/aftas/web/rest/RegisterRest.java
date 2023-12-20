package com.example.aftas.web.rest;


import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Ranking;
import com.example.aftas.services.EntityDTOConverterService;
import com.example.aftas.services.RegisterCompetitionService.RegisterCompetitionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterRest {
    private RegisterCompetitionService registerCompetitionService;
    private EntityDTOConverterService converterService;

    public RegisterRest(RegisterCompetitionService registerCompetitionService, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.registerCompetitionService = registerCompetitionService;
        this.converterService = converterService;
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> saveCompetition(@RequestBody Map<String, Integer> requestBody) {
        Long memberId = Long.valueOf(requestBody.get("memberId"));
        Long compId = Long.valueOf(requestBody.get("competitionId"));
        Ranking ranking = new Ranking();
        ranking.setRank(999);
        ranking.setScore(0);
        ResponseDTO savedRanking = registerCompetitionService.saveRegestration(ranking, memberId, compId);
            return new ResponseEntity<>(savedRanking, HttpStatus.OK);
    }
}

