package com.example.gameProject.controller;

import com.example.gameProject.entity.Quest;
import com.example.gameProject.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    @Autowired
    private QuestService questService;

    // Get all quests related to the jobId.
    @GetMapping("/by-job/{jobId}")
    public List<Quest> getQuestsByJob(@PathVariable Long jobId) {
        return questService.getQuestsByJob(jobId);
    }

    // Get all quests.
    @GetMapping
    public List<Quest> getAllQuests() {
        return questService.getAllQuests();
    }

}
