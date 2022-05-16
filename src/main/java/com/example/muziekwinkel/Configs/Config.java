package com.example.muziekwinkel.Configs;

import com.example.muziekwinkel.AppUserRole;
import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Models.Label;
import com.example.muziekwinkel.Models.AppUser;
import com.example.muziekwinkel.Repositories.ArtistRepository;
import com.example.muziekwinkel.Repositories.LabelRepository;
import com.example.muziekwinkel.Repositories.AppUserRepository;
import com.example.muziekwinkel.Security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@AllArgsConstructor
@Configuration
public class Config {
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner artistCommandLineRunner(ArtistRepository artistRepository) {
        return args -> {
            Artist beethoven = new Artist("Beethoven", 1770);
            artistRepository.save(beethoven);
        };
    }
    @Bean
    CommandLineRunner labelCommandLineRunner(LabelRepository labelRepository){
        //SEPARATE AND MAKE INDIVIDUAL CONFIGS
        return args ->{
            Label universal = new Label("Universal");
            labelRepository.save(universal);
        };
    }
    @Bean
    CommandLineRunner userCommandLineRunner(AppUserRepository appUserRepository){
        return args ->{
            AppUser admin = new AppUser("Rick", "AppAdmin", "Email", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.ADMIN, false, true);
            //AppUser appUser = new AppUser("Rick2", "AppUser", "Email", encoder.bCryptPasswordEncoder().encode("pass2"), AppUserRole.USER, false, true);
            appUserRepository.save(admin);
            //appUserRepository.save(appUser);
        };
    }
}
//TODO Rename package to lowercase