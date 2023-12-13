package com.example.aftas.services.Fish;

import com.example.aftas.entities.Fish;
import com.example.aftas.services.CrudService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface FishService extends CrudService<Fish , Long> {
    Fish saveFish(String name, Long av, Long level);
}
