package com.example.gameProject.repository;

import com.example.gameProject.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Data access with Job entity in database.
@Repository
// Extends Jpa to gain default methods.
public interface JobRepository extends JpaRepository<Job, Long> {
}
