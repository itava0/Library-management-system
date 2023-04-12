package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    //This field is annotated with @Id to indicate that it
    // is the primary key for the entity. The @SequenceGenerator
    // and @GeneratedValue annotations are used to automatically
    // generate unique primary key values for each new entity that is persisted.
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )




    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    //This field represents the age of the student,
    // which is calculated dynamically based on the date of birth and the current date.
    // The @Transient annotation is used to indicate that this
    // field should not be persisted in the database.
    @Transient
    private Integer age;


    public Student() {}

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob
                  ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob
                   ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    //These are getter and setter methods for the id, name, email, and dob fields.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    //This is an overridden toString() method that returns a string
    // representation of the Student object. It includes the values of the id,
    // name, email, dob, and age fields. This method is useful for debugging purposes.
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
