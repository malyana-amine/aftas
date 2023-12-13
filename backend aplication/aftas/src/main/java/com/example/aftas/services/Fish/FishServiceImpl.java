package com.example.aftas.services.Fish;

import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Level;
import com.example.aftas.repositories.FishRepository;
import com.example.aftas.repositories.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;


    public FishServiceImpl(FishRepository fishRepository, LevelRepository levelRepository) {
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
    }
    @Override
    public List<Fish> findAll() {
        return null;
    }

    @Override
    public Optional<Fish> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Fish save(Fish fish) {
        return null;
    }
    @Override
    public Fish saveFish(String name, Long av, Long level) {

        Optional<Level> level1 = levelRepository.findById(level);
        Fish fish = new Fish();
        fish.setLevel(level1.get());
        fish.setName(name);
        fish.setAverageWeight(Double.valueOf(av));



        return fishRepository.save(fish);
    }

    @Override
    public Fish update(Fish entityDTO) {
        return null;
    }

    @Override
    public Optional<Fish> delete(Long aLong) {
        return Optional.empty();
    }
}
