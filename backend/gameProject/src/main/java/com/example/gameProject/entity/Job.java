package com.example.gameProject.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int health;
    private int defense;
    private int mana;

    @ElementCollection
    private List<String> skills;

    // Default constructor
    public Job() {}

    // Parameterized constructor
    public Job(String name, int health, int defense, int mana, List<String> skills) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.mana = mana;
        this.skills = skills;
    }

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
}