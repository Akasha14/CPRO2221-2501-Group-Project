package com.example.gameProject.service;
import com.example.gameProject.entity.Job;
import com.example.gameProject.entity.Quest;
import com.example.gameProject.repository.QuestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class QuestServiceTest {

    // Mocked repositories.
    @Mock
    private QuestRepository questRepository;

    // Service being tested.
    @InjectMocks
    private QuestService questService;

    private Quest quest1;
    private Quest quest2;
    private Job job;

    // This runs before each test.
    @BeforeEach
    void setUp() {
        // Setup test data(job, 2 quests).
        job = new Job();
        job.setId(1L);

        quest1 = new Quest();
        quest1.setId(1L);
        quest1.setName("Quest 1");
        quest1.setDescription("First quest description");
        quest1.setXpReward(100);
        quest1.setJob(job);

        quest2 = new Quest();
        quest2.setId(2L);
        quest2.setName("Quest 2");
        quest2.setDescription("Second quest description");
        quest2.setXpReward(200);
        quest2.setJob(job);
    }

    @Test
    public void testGetQuestsByJob() {
        // Given (jobId and mock repository).
        when(questRepository.findByJobId(1L)).thenReturn(Arrays.asList(quest1, quest2));

        // Call get quests by job to test.
        List<Quest> quests = questService.getQuestsByJob(1L);

        // Verify the result (2 quests).
        assertNotNull(quests);
        assertEquals(2, quests.size());
        assertEquals("Quest 1", quests.get(0).getName());
        assertEquals("Quest 2", quests.get(1).getName());
        verify(questRepository, times(1)).findByJobId(1L);
    }

    @Test
    public void testGetAllQuests() {
        // Given (mock repository to return list of quests).
        when(questRepository.findAll()).thenReturn(Arrays.asList(quest1, quest2));

        // Call get all quests to test.
        List<Quest> quests = questService.getAllQuests();

        // Verify the result (2 quests).
        assertNotNull(quests);
        assertEquals(2, quests.size());
        verify(questRepository, times(1)).findAll();
    }

    @Test
    public void testGetQuestsByJobJobNotFound() {
        // Given (mock repository returning empty for a non-existing jobId).
        when(questRepository.findByJobId(anyLong())).thenReturn(Arrays.asList());

        // Call get quests by job with invalid job to test.
        List<Quest> quests = questService.getQuestsByJob(567L);

        // Verify the result (is null).
        assertNotNull(quests);
        assertTrue(quests.isEmpty());
        verify(questRepository, times(1)).findByJobId(567L);
    }
}