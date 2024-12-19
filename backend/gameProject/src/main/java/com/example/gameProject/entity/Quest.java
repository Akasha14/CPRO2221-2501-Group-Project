package com.example.gameProject.entity;

import jakarta.persistence.*;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int xpReward;

    @Column(name = "job_id") // Nullable, some quests not job-specific.
    private Job job;

    // Default constructor
    public Quest() {}

    // Getters and Setters
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public int getXpReward() {return xpReward;}

    public void setXpReward(int xpReward) {this.xpReward = xpReward;}

    public Job getJob() {return job;}

    public void setJob(Job job) {this.job = job;}
}
