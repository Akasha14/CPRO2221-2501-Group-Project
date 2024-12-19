package com.example.gameProject.service;

import org.springframework.stereotype.Service;
import com.example.gameProject.entity.Job;
import com.example.gameProject.repository.JobRepository;
import com.example.gameProject.entity.Character;
import com.example.gameProject.repository.CharacterRepository;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final JobRepository jobRepository; // Assuming a JobRepository exists to fetch Job details.

    public CharacterService(CharacterRepository characterRepository, JobRepository jobRepository) {
        this.characterRepository = characterRepository;
        this.jobRepository = jobRepository;
    }

    // Create a new Character
    public Character createCharacter(String name, Long jobId) {
        // Validate jobId by checking if the Job exists.
        if (!jobRepository.existsById(jobId)) {
            throw new IllegalArgumentException("Invalid Job ID: " + jobId);
        }

        // Create and save the character.
        Character character = new Character();
        character.setName(name);
        character.setJobId(jobId);
        return characterRepository.save(character);
    }

    // Retrieve all characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Retrieve a character by ID
    public Character getCharacterById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found with ID: " + id));
    }

    // Get the job details for a character
    public Job getJobForCharacter(Long characterId) {
        Character character = getCharacterById(characterId);
        return jobRepository.findById(character.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + character.getJobId()));
    }
}
