package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


//This is a Spring configuration class called
// StudentConfig. The class is annotated with
// @Configuration, indicating that it provides Spring with bean definitions.
@Configuration
public class StudentConfig {

    public StudentConfig() {}

    // The CommandLineRunner bean is responsible for
    // populating the StudentRepository with some initial data.
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            final Student mariam = new Student(
                    "Mariam",
                    "marian.jaml@gmail.com",
                    LocalDate.of(1995, Month.FEBRUARY, 5)
            );
            final Student alex = new Student(
                    "Mariam",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY, 5)
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
