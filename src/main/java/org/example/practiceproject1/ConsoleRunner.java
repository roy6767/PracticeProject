package org.example.practiceproject1;

import org.example.practiceproject1.models.HockeyPlayer;
import org.example.practiceproject1.models.HockeyPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    HockeyPlayerRepository hockeyPlayerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (hockeyPlayerRepository.count() == 0) {
            HockeyPlayer hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(52);
            hockeyPlayer.setName("Stefan");
            hockeyPlayerRepository.save(hockeyPlayer);

            HockeyPlayer hockeyPlayer2 = new HockeyPlayer();
            hockeyPlayer2.setAge(33);
            hockeyPlayer2.setName("Biplob");
            hockeyPlayerRepository.save(hockeyPlayer2);
        }
    }
}
