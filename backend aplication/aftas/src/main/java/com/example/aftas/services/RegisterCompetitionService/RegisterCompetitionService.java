package com.example.aftas.services.RegisterCompetitionService;

import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Ranking;
import com.example.aftas.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface RegisterCompetitionService extends CrudService<Ranking,Long> {
    ResponseDTO saveRegestration(Ranking entityDTO, Long memberId, Long compId);

}
