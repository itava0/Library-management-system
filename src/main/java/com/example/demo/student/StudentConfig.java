package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    public StudentConfig() {}

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            final Student mariam = new Student(
                    "Mariam",
                    "marian.jaml@gmail.com",
                    LocalDate.of(1995, Month.FEBRUARY, 5),
                    27
            );
            final Student alex = new Student(
                    "Mariam",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY, 5),
                    19
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
