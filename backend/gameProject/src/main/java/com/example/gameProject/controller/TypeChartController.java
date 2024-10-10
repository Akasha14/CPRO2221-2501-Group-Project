package com.example.gameProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gameProject.model.Attack;
import com.example.gameProject.model.ElementType;
import com.example.gameProject.service.DamageCalculator;
import com.example.gameProject.service.TypeChartService;

@RestController
@RequestMapping("/api/typechart")
public class TypeChartController {

    private final TypeChartService typeChartService;
    private final DamageCalculator damageCalculator;

    @Autowired
    public TypeChartController(TypeChartService typeChartService, DamageCalculator damageCalculator) {
        this.typeChartService = typeChartService;
        this.damageCalculator = damageCalculator;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Attack> calculateDamage(
            @RequestParam String elementType,
            @RequestParam String monsterType,
            @RequestParam String monsterElementType,
            @RequestParam int damageValue) {

        ElementType attackerType = ElementType.valueOf(elementType.toUpperCase());
        int finalDamage = damageCalculator.calculateDamage(attackerType, monsterType, monsterElementType, damageValue);

        Attack attack = new Attack();
        attack.setElementType(elementType);
        attack.setMonsterType(monsterType);
        attack.setMonsterElementType(monsterElementType);
        attack.setDamageValue(damageValue);
        attack.setFinalDamage(finalDamage);

        return ResponseEntity.ok(attack);
    }
}
