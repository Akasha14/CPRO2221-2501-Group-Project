package com.example.gameProject.service;

import com.example.gameProject.entity.Quest;
import com.example.gameProject.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    public List<Quest> getQuestsByJob(Long jobId) {
        return questRepository.findByJobId(jobId);
    }


    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }
}
