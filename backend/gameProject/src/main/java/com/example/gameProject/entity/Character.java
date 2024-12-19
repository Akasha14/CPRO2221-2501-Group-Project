package com.example.gameProject.entity;

import jakarta.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "job_id", nullable = false)
    private Long jobId; // Foreign key to Job.

    private int health;
    private int mana;
    private int defense;

    // Default constructor
    public Character() {}

    // Getters and Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Long getJobId() {return jobId;}

    public void setJobId(Long jobId) {this.jobId = jobId;}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public int getMana() {return mana;}

    public void setMana(int mana) {this.mana = mana;}

    public int getDefense() {return defense;}

    public void setDefense(int defense) {this.defense = defense;}
}