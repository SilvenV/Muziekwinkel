package com.example.muziekwinkel.configs;

import com.example.muziekwinkel.AppUserRole;
import com.example.muziekwinkel.models.AppUser;
import com.example.muziekwinkel.repositories.AppUserRepository;
import com.example.muziekwinkel.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@AllArgsConstructor
@Configuration
public class AppUserConfig {
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner userCommandLineRunner(AppUserRepository appUserRepository){
        return args ->{
            AppUser admin = new AppUser("Rick", "AppAdmin", encoder.bCryptPasswordEncoder().encode("pass"), AppUserRole.ADMIN, false, true);
            AppUser appUser = new AppUser("Rick2", "AppUser", encoder.bCryptPasswordEncoder().encode("pass2"), AppUserRole.USER, false, true);
            appUserRepository.save(admin);
            appUserRepository.save(appUser);
        };
    }
}