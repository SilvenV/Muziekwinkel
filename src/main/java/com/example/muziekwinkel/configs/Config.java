package com.example.muziekwinkel.configs;

import com.example.muziekwinkel.AppUserRole;
import com.example.muziekwinkel.models.Album;
import com.example.muziekwinkel.models.AppUser;
import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.repositories.AlbumRepository;
import com.example.muziekwinkel.repositories.AppUserRepository;
import com.example.muziekwinkel.repositories.ArtistRepository;
import com.example.muziekwinkel.repositories.LabelRepository;
import com.example.muziekwinkel.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Config {
    private final ArtistRepository artistRepository;
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner userCommandLineRunner(AppUserRepository appUserRepository) {
        return args -> {
            AppUser admin = new AppUser("Rick", "AppAdmin", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.ADMIN, false, true);
            AppUser appUser = new AppUser("Rick2", "AppUser", encoder.bCryptPasswordEncoder().encode("pass2"), AppUserRole.USER, false, true);
            appUserRepository.save(admin);
            appUserRepository.save(appUser);
        };
    }

    @Bean
    CommandLineRunner labelCommandLineRunner(LabelRepository labelRepository) {
        return args -> {
            Label universal = new Label("Universal");
            labelRepository.save(universal);
        };
    }

    @Bean
    CommandLineRunner artistCommandLineRunner(ArtistRepository artistRepository) {
        return args -> {
            Artist beethoven = new Artist("Beethoven", 1770);
            artistRepository.save(beethoven);
        };
    }

    @Bean
    CommandLineRunner albumCommandLineRunner(AlbumRepository albumRepository) {
        return args -> {
            Album symphony9 = new Album("Symphony 9", artistRepository.findArtistByName("Beethoven"));
            albumRepository.save(symphony9);
        };
    }
}
