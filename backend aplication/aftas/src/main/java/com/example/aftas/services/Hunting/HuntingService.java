package com.example.aftas.services.Hunting;

import com.example.aftas.entities.Hunting;
import com.example.aftas.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface HuntingService extends CrudService<Hunting, Long> {
    Hunting saveHunting(Long membeId, Long mompId, Long fishId);
}