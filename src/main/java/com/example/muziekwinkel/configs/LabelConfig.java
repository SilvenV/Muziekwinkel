package com.example.muziekwinkel.configs;

import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.repositories.LabelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabelConfig {
    @Bean
    CommandLineRunner labelCommandLineRunner(LabelRepository labelRepository){
        //SEPARATE AND MAKE INDIVIDUAL CONFIGS
        return args ->{
            Label universal = new Label("Universal");
            labelRepository.save(universal);
        };
    }
}
