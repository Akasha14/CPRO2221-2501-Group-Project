package com.example.gameProject.model;

import java.util.HashMap;
import java.util.Map;

public class TypeEffectiveness {

    private static final Map<ElementType, Map<ElementType, Double>> effectivenessMap = new HashMap<>();

    static {
        for (ElementType type : ElementType.values()) {
            effectivenessMap.put(type, new HashMap<>());
        }

        // Set effectiveness values
        effectivenessMap.get(ElementType.FIRE).put(ElementType.GRASS, 1.5);
        effectivenessMap.get(ElementType.FIRE).put(ElementType.WATER, 0.5);
        effectivenessMap.get(ElementType.FIRE).put(ElementType.MAGIC, 1.0);
        effectivenessMap.get(ElementType.FIRE).put(ElementType.ANTI_MAGIC, 1.0);
        
        effectivenessMap.get(ElementType.WATER).put(ElementType.FIRE, 1.5);
        effectivenessMap.get(ElementType.WATER).put(ElementType.GRASS, 0.5);
        effectivenessMap.get(ElementType.WATER).put(ElementType.MAGIC, 1.0);
        effectivenessMap.get(ElementType.WATER).put(ElementType.ANTI_MAGIC, 1.0);
        
        effectivenessMap.get(ElementType.GRASS).put(ElementType.WATER, 1.5);
        effectivenessMap.get(ElementType.GRASS).put(ElementType.FIRE, 0.5);
        effectivenessMap.get(ElementType.GRASS).put(ElementType.MAGIC, 1.0);
        effectivenessMap.get(ElementType.GRASS).put(ElementType.ANTI_MAGIC, 1.0);
        
        effectivenessMap.get(ElementType.MAGIC).put(ElementType.ANTI_MAGIC, 1.5);
        effectivenessMap.get(ElementType.MAGIC).put(ElementType.FIRE, 1.0);
        effectivenessMap.get(ElementType.MAGIC).put(ElementType.WATER, 1.0);
        effectivenessMap.get(ElementType.MAGIC).put(ElementType.GRASS, 1.0);
        
        effectivenessMap.get(ElementType.ANTI_MAGIC).put(ElementType.MAGIC, 1.5);
        effectivenessMap.get(ElementType.ANTI_MAGIC).put(ElementType.FIRE, 1.0);
        effectivenessMap.get(ElementType.ANTI_MAGIC).put(ElementType.WATER, 1.0);
        effectivenessMap.get(ElementType.ANTI_MAGIC).put(ElementType.GRASS, 1.0);
    }

    public static double getEffectiveness(ElementType attacker, ElementType defender) {
        return effectivenessMap.getOrDefault(attacker, new HashMap<>()).getOrDefault(defender, 1.0);
    }
}
