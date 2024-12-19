package com.example.gameProject.controller;

import com.example.gameProject.entity.Job;
import com.example.gameProject.entity.Character;
import com.example.gameProject.repository.CharacterRepository;
import com.example.gameProject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        // Find the Job entity by ID using the jobId from the request body.
        Job job = jobRepository.findById(character.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Set fields based on the Job.
        character.setHealth(job.getHealth());
        character.setMana(job.getMana());
        character.setDefense(job.getDefense());

        // Save the Character entity.
        return characterRepository.save(character);
    }
}
