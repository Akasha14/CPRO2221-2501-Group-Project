package com.example.gameProject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attacks")
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String elementType;

    @Column(nullable = false)
    private String monsterType;

    @Column(nullable = false)
    private String attackType;

    @Column(nullable = false)
    private String monsterElementType;

    @Column(nullable = false)
    private int damageValue;

    @Column(nullable = false)
    private int rollValue;

    @Column(nullable = false)
    private int finalDamage;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Attack() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getMonsterElementType() {
        return monsterElementType;
    }

    public void setMonsterElementType(String monsterElementType) {
        this.monsterElementType = monsterElementType;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public int getRollValue() {
        return rollValue;
    }

    public void setRollValue(int rollValue) {
        this.rollValue = rollValue;
    }

    public int getFinalDamage() {
        return finalDamage;
    }

    public void setFinalDamage(int finalDamage) {
        this.finalDamage = finalDamage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
