package com.example.aftas.seeder.dbSeeders;


import com.example.aftas.entities.Level;
import com.example.aftas.repositories.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LevelSeeder {
    private final LevelRepository levelRepository;

    private final Level[] levels = {
            Level.builder().code(1).point(50).description("Just starting out! Catch easy-to-find and smaller fishes.").build(),
            Level.builder().code(2).point(100).description("Progressing well. Aim for a variety of medium-sized fishes.").build(),
            Level.builder().code(3).point(200).description("Demonstrating proficiency. Challenge yourself with larger and more challenging catches.").build(),
            Level.builder().code(4).point(400).description("A seasoned angler. Go after specific species and explore different fishing techniques.").build(),
            Level.builder().code(5).point(800).description("Mastering the art of fishing. Pursue the biggest and most elusive ocean dwellers.").build(),
            Level.builder().code(6).point(1500).description("Attained legendary status. Share your knowledge and skills with other fishing enthusiasts.").build(),
            Level.builder().code(7).point(2500).description("Among the elite. Hunt challenging species in deep waters.").build(),
            Level.builder().code(8).point(4000).description("Unravel the mysteries of the ocean. Encounter rare and mystical sea creatures.").build(),
            Level.builder().code(9).point(6000).description("Conquer the vast expanse of the ocean. Seek out legendary and elusive marine species.").build(),
            Level.builder().code(10).point(7500).description("A hunter of titanic proportions. Pursue the largest and most legendary oceanic trophies.").build()
    };



    private LevelSeeder(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    private void log(){
        System.out.println("----------------------Level Seeder----------------------");
    }

    public void seed() {
        this.log();
        if(levelRepository.findAll().isEmpty())
            levelRepository.saveAll(Arrays.stream(levels).toList());
    }
}
