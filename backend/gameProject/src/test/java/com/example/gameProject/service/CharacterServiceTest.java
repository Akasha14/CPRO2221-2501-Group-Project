package com.example.gameProject.service;

import com.example.gameProject.entity.Character;
import com.example.gameProject.entity.Job;
import com.example.gameProject.repository.CharacterRepository;
import com.example.gameProject.repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CharacterServiceTest {

    // Mocked repositories.
    private CharacterRepository characterRepository;
    private JobRepository jobRepository;

    // Service being tested.
    private CharacterService characterService;

    // This runs before each test.
    @BeforeEach
    void setUp() {
        characterRepository = mock(CharacterRepository.class);
        jobRepository = mock(JobRepository.class);
        // Service made with mocked repos.
        characterService = new CharacterService(characterRepository, jobRepository);
    }

    @Test
    void createCharacter_Success() {
        // Given (name, ID).
        String name = "Hero";
        Long jobId = 1L;
        Job job = new Job();
        job.setId(jobId);

        when(jobRepository.existsById(jobId)).thenReturn(true);

        // Call create character to test.
        Character createdCharacter = characterService.createCharacter(name, jobId);

        // Save once.
        verify(characterRepository, times(1)).save(Mockito.any(Character.class));
        // Ensure character not null.
        assertNotNull(createdCharacter);
        // Ensures name and jobId are set.
        assertEquals(name, createdCharacter.getName());
        assertEquals(jobId, createdCharacter.getJobId());
    }

    @Test
    void getAllCharacters_Success() {
        // Given (list of characters from repo).
        // Simulate the repository returning 3 characters.
        List<Character> characters = List.of(new Character(), new Character(), new Character());
        when(characterRepository.findAll()).thenReturn(characters);

        // Call get all characters to test.
        List<Character> result = characterService.getAllCharacters();

        // The number of characters returned should match the repository data.
        assertEquals(characters.size(), result.size());
        // Call only once.
        verify(characterRepository, times(1)).findAll();
    }


    @Test
    void getCharacterById_Success() {
        // Given (character object).
        Long characterId = 1L;
        Character character = new Character();
        character.setId(characterId);

        when(characterRepository.findById(characterId)).thenReturn(Optional.of(character));

        // Call get character by id to test.
        Character result = characterService.getCharacterById(characterId);

        // Ensure not null, verify correct ID is returned.
        assertNotNull(result);
        assertEquals(characterId, result.getId());
        verify(characterRepository, times(1)).findById(characterId);
    }

}
