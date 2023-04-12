package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//The JpaRepository interface provides several methods for basic
// CRUD (Create, Read, Update, Delete) operations on Student
// entities, which this interface inherits. These methods include
// save, findAll, findById, and delete, among others.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //The interface declares a custom query method named findStudentByEmail
    // that retrieves a Student entity from the database by email.
    // This query is defined using the @Query annotation, which takes a
    // JPQL (Java Persistence Query Language) query string as its value.
    //This method returns an Optional of Student, which allows callers to
    // handle null results gracefully.
    // SELECT * FROM student WHERE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
