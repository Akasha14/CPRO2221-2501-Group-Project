package com.example.gameProject.service;

import com.example.gameProject.entity.Job;
import com.example.gameProject.repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobServiceTest {

    // Mocked repo.
    private JobRepository jobRepository;

    // Service being tested.
    private JobService jobService;

    // This runs before each test.
    @BeforeEach
    void setUp() {
        // Mock instance of JobRepository.
        jobRepository = mock(JobRepository.class);
        jobService = new JobService();

        // Inject mock repository into service.
        jobService.jobRepository = jobRepository;
    }

    @Test
    void getAllJobs_Success() {
        // Given (3 job objects).
        Job job1 = new Job();
        job1.setId(1L);
        job1.setName("Merchant");
        Job job2 = new Job();
        job2.setId(2L);
        job2.setName("Bandit");
        Job job3 = new Job();
        job3.setId(3L);
        job3.setName("Werewolf");

        List<Job> mockJobs = List.of(job1, job2, job3);
        when(jobRepository.findAll()).thenReturn(mockJobs);

        // Call get all jobs to test.
        List<Job> result = jobService.getAllJobs();

        // Ensure not null, expect 3 results.
        assertNotNull(result);
        assertEquals(3, result.size());
        // The first job's name should be 'Merchant'.
        assertEquals("Merchant", result.get(0).getName());
        // Only called once.
        verify(jobRepository, times(1)).findAll();
    }

    @Test
    void getJobById_Success() {
        // Given (job object 'Merchant').
        Long jobId = 1L;
        Job job = new Job();
        job.setId(jobId);
        job.setName("Merchant");

        when(jobRepository.findById(jobId)).thenReturn(Optional.of(job));

        // Call get job by id to test.
        Job result = jobService.getJobById(jobId);

        assertNotNull(result);
        // The job ID and name should match.
        assertEquals(jobId, result.getId());
        assertEquals("Merchant", result.getName());
        verify(jobRepository, times(1)).findById(jobId);
    }

    @Test
    void getJobById_NotFound() {
        // Given (jobId).
        Long jobId = 1L;
        // Returns empty to simulate non-existent job.
        when(jobRepository.findById(jobId)).thenReturn(Optional.empty());

        // Call get job by id to test.
        Job result = jobService.getJobById(jobId);

        // Ensure is null, job not found.
        assertNull(result);
        verify(jobRepository, times(1)).findById(jobId);
    }
}

