package com.example.gameProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gameProject.entity.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
