package com.example.gameProject.controller;

import com.example.gameProject.entity.CreatureType;
import com.example.gameProject.service.CreatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing CreatureType entities.
 * Provides endpoints to create, read, update, and delete CreatureType data.
 */
@RestController
@RequestMapping("/creature-types")
public class CreatureTypeController {

    @Autowired
    private CreatureTypeService creatureTypeService;

    /**
     * Retrieves a list of all CreatureTypes from the database.
     * @return A list of all CreatureTypes.
     */
    @GetMapping
    public List<CreatureType> getAllCreatureTypes() {
        return creatureTypeService.findAll();
    }

    /**
     * Retrieves a specific CreatureType by its ID.
     * @param id The ID of the CreatureType.
     * @return The CreatureType if found.
     */
    @GetMapping("/{id}")
    public CreatureType getCreatureTypeById(@PathVariable Long id) {
        return creatureTypeService.findById(id)
                .orElseThrow(() -> new RuntimeException("CreatureType not found"));
    }

    /**
     * Creates a new CreatureType entity in the database.
     * @param creatureType The CreatureType data to be saved.
     * @return The newly created CreatureType.
     */
    @PostMapping
    public CreatureType createCreatureType(@RequestBody CreatureType creatureType) {
        return creatureTypeService.createCreatureType(creatureType);
    }

    /**
     * Updates an existing CreatureType by its ID.
     * @param id The ID of the CreatureType to be updated.
     * @param creatureType The updated CreatureType data.
     * @return The updated CreatureType if successful.
     */
    @PutMapping("/{id}")
    public CreatureType updateCreatureType(@PathVariable Long id, @RequestBody CreatureType creatureType) {
        return creatureTypeService.updateCreatureType(id, creatureType);
    }

    /**
     * Deletes a specific CreatureType by its ID.
     * @param id The ID of the CreatureType to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteCreatureType(@PathVariable Long id) {
        creatureTypeService.deleteCreatureType(id);
    }
}
