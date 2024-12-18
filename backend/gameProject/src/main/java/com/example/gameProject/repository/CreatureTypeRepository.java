package com.example.gameProject.repository;

import com.example.gameProject.entity.CreatureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing CreatureType entities.
 * Extends JpaRepository to provide basic CRUD operations on the CreatureType table.
 */
@Repository
public interface CreatureTypeRepository extends JpaRepository<CreatureType, Long> {
}
