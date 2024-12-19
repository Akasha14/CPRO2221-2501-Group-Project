package com.example.gameProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.gameProject.entity.Quest;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    List<Quest> findByJobId(Long jobId);
}
