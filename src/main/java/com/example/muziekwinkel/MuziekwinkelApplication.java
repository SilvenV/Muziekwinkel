package com.example.muziekwinkel;

import com.example.muziekwinkel.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MuziekwinkelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuziekwinkelApplication.class, args);
        //TODO WAAROM KAN IK NIET INLOGGEN FFFFFFF-
        User user = new User("Rick", "Silven", "Email", "pass", AppUserRole.ADMIN, false, true);
    }
}