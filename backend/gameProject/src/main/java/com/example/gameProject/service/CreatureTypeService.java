package com.example.gameProject.service;

import com.example.gameProject.entity.CreatureType;
import com.example.gameProject.repository.CreatureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class that handles the business logic for CreatureType entities.
 * Communicates with the CreatureTypeRepository to perform CRUD operations.
 */
@Service
public class CreatureTypeService {

    @Autowired
    private CreatureTypeRepository creatureTypeRepository;

    /**
     * Retrieves all CreatureType entities from the database.
     * @return A list of all CreatureType entities.
     */
    public List<CreatureType> findAll() {
        return creatureTypeRepository.findAll();
    }

    /**
     * Finds a specific CreatureType by its ID.
     * @param id The ID of the CreatureType.
     * @return An Optional containing the CreatureType if found, otherwise empty.
     */
    public Optional<CreatureType> findById(Long id) {
        return creatureTypeRepository.findById(id);
    }

    /**
     * Creates a new CreatureType entity in the database.
     * Validates that the name is not null or empty and sets the createdAt timestamp.
     * @param creatureType The CreatureType entity to be created.
     * @return The newly created CreatureType.
     */
    public CreatureType createCreatureType(CreatureType creatureType) {
        if (creatureType.getName() == null || creatureType.getName().isEmpty()) {
            throw new IllegalArgumentException("Creature type name cannot be null or empty");
        }
        creatureType.setCreatedAt(LocalDateTime.now()); // Automatically set the current timestamp
        return creatureTypeRepository.save(creatureType);
    }

    /**
     * Updates an existing CreatureType entity based on its ID.
     * @param id The ID of the CreatureType to be updated.
     * @param updatedCreatureType The updated data for the CreatureType.
     * @return The updated CreatureType if found and updated, otherwise throws an exception.
     */
    public CreatureType updateCreatureType(Long id, CreatureType updatedCreatureType) {
        return creatureTypeRepository.findById(id).map(creatureType -> {
            creatureType.setName(updatedCreatureType.getName());
            creatureType.setDescription(updatedCreatureType.getDescription());
            creatureType.setHealthModifier(updatedCreatureType.getHealthModifier());
            creatureType.setAttackModifier(updatedCreatureType.getAttackModifier());
            return creatureTypeRepository.save(creatureType);
        }).orElseThrow(() -> new RuntimeException("CreatureType not found"));
    }

    /**
     * Deletes a specific CreatureType from the database based on its ID.
     * @param id The ID of the CreatureType to be deleted.
     */
    public void deleteCreatureType(Long id) {
        creatureTypeRepository.deleteById(id);
    }
}
