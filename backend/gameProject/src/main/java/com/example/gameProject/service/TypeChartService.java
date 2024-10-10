package com.example.gameProject.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gameProject.exception.InvalidInputException;
import com.example.gameProject.model.Attack;
import com.example.gameProject.repository.AttackRepository;

@Service
public class TypeChartService {

    private final AttackRepository attackRepository;
    private final Random random = new Random();

    private static final List<String> VALID_ELEMENTS = Arrays.asList("fire", "water", "grass", "magic", "anti-magic");
    private static final List<String> VALID_MONSTER_TYPES = Arrays.asList("humanoid", "beast", "celestial", "demon");

    @Autowired
    public TypeChartService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    public Attack calculateDamage(String elementType, String monsterType, String monsterElementType, String attackType, int damageValue) {
        validateInput(elementType, monsterType, damageValue);

        int rollValue = random.nextInt(10) + 1;
        int finalDamage = calculateFinalDamage(elementType, monsterType, monsterElementType, damageValue, rollValue);

        Attack attack = new Attack();
        attack.setElementType(elementType);
        attack.setMonsterType(monsterType);
        attack.setMonsterElementType(monsterElementType);
        attack.setAttackType(attackType);
        attack.setDamageValue(damageValue);
        attack.setRollValue(rollValue);
        attack.setFinalDamage(finalDamage);

        return attackRepository.save(attack);
    }

    private void validateInput(String elementType, String monsterType, int damageValue) {
        if (!VALID_ELEMENTS.contains(elementType.toLowerCase())) {
            throw new InvalidInputException("Invalid element type: " + elementType);
        }
        if (!VALID_MONSTER_TYPES.contains(monsterType.toLowerCase())) {
            throw new InvalidInputException("Invalid monster type: " + monsterType);
        }
        if (damageValue <= 0) {
            throw new InvalidInputException("Damage value must be positive");
        }
    }

    private int calculateFinalDamage(String elementType, String monsterType, String monsterElementType, int damageValue, int rollValue) {
        double multiplier = 1.0;

        if (elementType.equals("fire") && monsterElementType.equals("grass")) {
            multiplier *= 1.5;
        } else if (elementType.equals("grass") && monsterElementType.equals("water")) {
            multiplier *= 1.5;
        } else if (elementType.equals("water") && monsterElementType.equals("fire")) {
            multiplier *= 1.5;
        } else if (elementType.equals("magic") && monsterElementType.equals("anti-magic")) {
            multiplier *= 1.5;
        } else if (elementType.equals("anti-magic") && (monsterElementType.equals("fire") || monsterElementType.equals("water") || monsterElementType.equals("grass"))) {
            multiplier *= 0.5;
        }

        multiplier *= (rollValue / 10.0) + 0.5;

        return (int) Math.round(damageValue * multiplier);
    }

    public Attack getAttack(Long id) {
        return attackRepository.findById(id)
                .orElseThrow(() -> new InvalidInputException("Attack not found with id: " + id));
    }

    public List<Attack> getAllAttacks() {
        return attackRepository.findAll();
    }

    public Attack updateAttack(Long id, Attack attackDetails) {
        Attack attack = getAttack(id);
        attack.setElementType(attackDetails.getElementType());
        attack.setMonsterType(attackDetails.getMonsterType());
        attack.setMonsterElementType(attackDetails.getMonsterElementType()); // Update monster element type
        attack.setDamageValue(attackDetails.getDamageValue());
        return attackRepository.save(attack);
    }

    public void deleteAttack(Long id) {
        Attack attack = getAttack(id);
        attackRepository.delete(attack);
    }
}
