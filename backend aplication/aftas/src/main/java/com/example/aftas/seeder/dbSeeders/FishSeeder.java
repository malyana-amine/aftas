package com.example.aftas.seeder.dbSeeders;


import com.example.aftas.entities.Fish;
import com.example.aftas.entities.Level;
import com.example.aftas.repositories.FishRepository;
import com.example.aftas.repositories.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class FishSeeder {
    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;
    private final Fish[] fishes = {
        Fish.builder().name("Tuna").averageWeight(5.0).level(Level.builder().build()).build(),
        Fish.builder().name("Salmon").averageWeight(2.0).level(Level.builder().build()).build(),
        Fish.builder().name("Flounder").averageWeight(0.7).level(Level.builder().build()).build(),
        Fish.builder().name("Perch").averageWeight(0.8).level(Level.builder().build()).build(),
        Fish.builder().name("Carp").averageWeight(3.0).level(Level.builder().build()).build(),
        Fish.builder().name("Cod").averageWeight(2.0).level(Level.builder().build()).build(),
        Fish.builder().name("Haddock").averageWeight(1.5).level(Level.builder().build()).build(),
        Fish.builder().name("Red Snapper").averageWeight(2.0).level(Level.builder().build()).build(),
        Fish.builder().name("Snapper").averageWeight(2.5).level(Level.builder().build()).build(),
        Fish.builder().name("Bass").averageWeight(3.0).level(Level.builder().build()).build(),
        Fish.builder().name("Trout").averageWeight(1.0).level(Level.builder().build()).build(),
        Fish.builder().name("Grouper").averageWeight(4.0).level(Level.builder().build()).build(),
        Fish.builder().name("Mahi-Mahi").averageWeight(7.0).level(Level.builder().build()).build()
    };

    public FishSeeder(FishRepository fishRepository, LevelRepository levelRepository) {
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
    }
    private void log(){
        System.out.println("----------------------Fish Seeder----------------------");
    }
    public void seed() {
        this.log();
        if(fishRepository.findAll().isEmpty())
            Arrays.stream(fishes).forEach(fish -> {
                Optional<Level> optionalLevel = levelRepository.getLevelByCode(1);
                if(optionalLevel.isPresent()){
                    fish.setLevel(optionalLevel.get());
                    fishRepository.save(fish);
                }
            });
    }


}
