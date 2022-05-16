package com.example.muziekwinkel.Configs;

import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Models.Label;
import com.example.muziekwinkel.Repositories.ArtistRepository;
import com.example.muziekwinkel.Repositories.LabelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    CommandLineRunner artistCommandLineRunner(ArtistRepository artistRepository) {
        return args -> {
            Artist beethoven = new Artist();
        };
    }
    @Bean
    CommandLineRunner labelCommandLineRunner(LabelRepository labelRepository){
        //SEPARATE AND MAKE INDIVIDUAL CONFIGS
        return args ->{
            Label universal = new Label();
        };
    }
}
//TODO Rename package to lowercase