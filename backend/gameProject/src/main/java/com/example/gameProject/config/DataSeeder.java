package com.example.gameProject.config;
import java.util.List;
import com.example.gameProject.entity.Job;
import com.example.gameProject.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    // Seeding data so no manual inserts.
    @Bean
    public CommandLineRunner seedData(JobRepository jobRepository) {
        return args -> {
            // Check if the database already contains jobs
            if (jobRepository.count() == 0) {
                // Create sample Job objects and save them to the database
                Job merchant = new Job();
                merchant.setName("Merchant");
                merchant.setHealth(150);
                merchant.setDefense(80);
                merchant.setMana(200);
                merchant.setSkills(List.of("Defensive Stance", "Coin Distraction", "Hire Mercenary"));
                
                Job bandit = new Job();
                bandit.setName("Bandit");
                bandit.setHealth(120);
                bandit.setDefense(50);
                bandit.setMana(175);
                bandit.setSkills(List.of("Smoke-Escape", "Back-stab", "Dual-Wield"));

                Job werewolf = new Job();
                werewolf.setName("Werewolf");
                werewolf.setHealth(150);
                werewolf.setDefense(40);
                werewolf.setMana(100);
                werewolf.setSkills(List.of("Bite", "Claw Attack", "Howl"));

                // Save jobs to the database
                jobRepository.save(merchant);
                jobRepository.save(bandit);
                jobRepository.save(werewolf);

                System.out.println("Sample job data inserted.");
            } else {
                System.out.println("Job data already exists.");
            }
        };
    }
}
