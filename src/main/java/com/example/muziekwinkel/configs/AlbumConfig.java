package com.example.muziekwinkel.configs;

import com.example.muziekwinkel.models.Album;
import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.repositories.AlbumRepository;
import com.example.muziekwinkel.repositories.ArtistRepository;
import com.example.muziekwinkel.repositories.LabelRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AlbumConfig {

    private final ArtistRepository artistRepository;
    private final LabelRepository labelRepository;

    @Bean
    CommandLineRunner albumCommandLineRunner(AlbumRepository albumRepository) {
        return args -> {
            Album symphony9 = new Album();
            symphony9.setArtist(artistRepository.findArtistByName("Beethoven"));
            albumRepository.save(symphony9);
        };
    }
}
//TODO Album initialisation doesn't register artist and label