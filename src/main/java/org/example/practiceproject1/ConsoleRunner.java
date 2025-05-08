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
    public void run(String... args) throws Exception{
        if(hockeyPlayerRepository.count() == 0) {
            HockeyPlayer hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(52);
            hockeyPlayer.setName("Stefan");
            hockeyPlayer.setGoalsScored(10);
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(35);
            hockeyPlayer.setName("Elijah");
            hockeyPlayer.setGoalsScored(6);
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(25);
            hockeyPlayer.setName("Mohammad");
            hockeyPlayer.setGoalsScored(6);
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(25);
            hockeyPlayer.setName("Edu");
            hockeyPlayer.setGoalsScored(7);
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(33);
            hockeyPlayer.setName("Biplob");
            hockeyPlayer.setGoalsScored(2);
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(33);
            hockeyPlayer.setName("Bithun");
            hockeyPlayer.setGoalsScored(6);
            hockeyPlayerRepository.save(hockeyPlayer);
        }
    }




}
