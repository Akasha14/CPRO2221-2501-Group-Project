package com.example.gameProject.service;

import org.springframework.stereotype.Service;

import com.example.gameProject.model.ElementType;

@Service
public class DamageCalculator {

    public int calculateDamage(ElementType attackerType, String monsterType, String monsterElementType, int damageValue) {
        double multiplier = 1.0;

        // Logic for determining damage based on element type effectiveness
        if (attackerType == ElementType.MAGIC) {
            multiplier *= 1.5; // Magic attacks have increased effectiveness
        } else if (attackerType == ElementType.ANTI_MAGIC) {
            if (monsterElementType.equalsIgnoreCase("fire") || 
                monsterElementType.equalsIgnoreCase("water") || 
                monsterElementType.equalsIgnoreCase("grass")) {
                multiplier *= 0.5; // Anti-magic is less effective against certain elements
            }
        } else {
            // Type effectiveness logic for elemental interactions
            if ((attackerType == ElementType.FIRE && monsterElementType.equalsIgnoreCase("grass")) ||
                (attackerType == ElementType.GRASS && monsterElementType.equalsIgnoreCase("water")) ||
                (attackerType == ElementType.WATER && monsterElementType.equalsIgnoreCase("fire"))) {
                multiplier *= 1.5; // Strong against
            }
        }

        return (int) Math.round(damageValue * multiplier); // Calculate final damage
    }
}
