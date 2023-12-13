package com.example.aftas.web.rest;

import com.example.aftas.DTO.HuntingDTO;
import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import com.example.aftas.services.EntityDTOConverterService;
import com.example.aftas.services.Hunting.HuntingService;
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
@RequestMapping("/Hunting")
public class HuntingRest {
    private HuntingService huntingService;
    private EntityDTOConverterService converterService;

    public HuntingRest(HuntingService huntingService, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.huntingService = huntingService;
        this.converterService = converterService;
    }

    @PostMapping("/add")
    public ResponseEntity<HuntingDTO> saveHunting(@RequestBody Map<String, Integer> requestBody) {

        Long fishId = Long.valueOf(requestBody.get("fishId"));
        Long memberId = Long.valueOf(requestBody.get("memberId"));
        Long compId = Long.valueOf(requestBody.get("compId"));

        Hunting hunting = huntingService.saveHunting(memberId,compId,fishId);
        HuntingDTO huntingDTO = converterService.convertToDTO(hunting);
        return new ResponseEntity<>(huntingDTO, HttpStatus.OK);
    }
}


