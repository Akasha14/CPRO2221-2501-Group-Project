package com.example.gameProject.service;

import com.example.gameProject.entity.Job;
import com.example.gameProject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Link between controller and repository.
@Service
public class JobService {

    // Methods telling how data is handled related to job entity.
    @Autowired
    public JobRepository jobRepository;
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
}