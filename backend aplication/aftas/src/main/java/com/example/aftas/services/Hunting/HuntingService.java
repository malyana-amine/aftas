package com.example.aftas.services.Hunting;

import com.example.aftas.DTO.ResponseDTO;
import com.example.aftas.entities.Hunting;
import com.example.aftas.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface HuntingService extends CrudService<Hunting, Long> {
    ResponseDTO saveHunting(Long membeId, Long mompId, Long fishId, Double av);
}