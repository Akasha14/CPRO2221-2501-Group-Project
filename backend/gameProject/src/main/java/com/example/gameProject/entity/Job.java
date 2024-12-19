package com.example.gameProject.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Job {
    // Primary Key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Attributes.
    private String name;
    private int health;
    private int defense;
    private int mana;

    // Creates separate table to link jobs and skills.
    @ElementCollection
    private List<String> skills;

    // Default constructor
    public Job() {}

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public int getMana() {
        return mana;
    }
    public List<String> getSkills() {
        return skills;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}