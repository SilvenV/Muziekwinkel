package com.example.muziekwinkel.configs;

import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.repositories.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtistConfig {
    @Bean
    CommandLineRunner artistCommandLineRunner(ArtistRepository artistRepository) {
        return args -> {
            Artist beethoven = new Artist("Beethoven", 1770);
            artistRepository.save(beethoven);
        };
    }
}
