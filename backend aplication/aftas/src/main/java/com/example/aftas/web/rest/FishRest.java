package com.example.aftas.web.rest;

import com.example.aftas.DTO.FishDTO;
import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.DTO.requestBody.FishRequest;
import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Member;
import com.example.aftas.services.EntityDTOConverterService;
import com.example.aftas.services.Fish.FishService;
import com.example.aftas.services.Hunting.HuntingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fish")
public class FishRest {
    private FishService fishService;
    private EntityDTOConverterService converterService;
    public FishRest(FishService fishService, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.fishService = fishService;
        this.converterService = converterService;
    }
    @PostMapping("/add")
    public ResponseEntity<FishDTO> saveMember(@RequestBody FishRequest requestBody) {
        String name = requestBody.getName();
        Integer av = requestBody.getAv();
        Long level = requestBody.getLevel();
        Fish fish = fishService.saveFish(name, av.longValue(), level);
        FishDTO fishDTO = converterService.convertToDTO(fish);
        return new ResponseEntity<>(fishDTO, HttpStatus.OK);
    }


}
