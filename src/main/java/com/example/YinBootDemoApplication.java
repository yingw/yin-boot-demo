package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class YinBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YinBootDemoApplication.class, args);
    }
}

@Component
class UserDataInitiatorCLR implements CommandLineRunner {
    @Autowired
    UserRepository userRepo;

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Yin Guo Wei", "Rick", "Jon", "James", "Aimee", "Will").forEach(
                name -> userRepo.save(new User(name).setCreated(LocalDate.now()))
        );
    }
}