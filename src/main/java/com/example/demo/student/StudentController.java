package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    // Constructor that injects the StudentService instance using @Autowired
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handles HTTP GET requests for retrieving a list of all students
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // Handles HTTP POST requests for adding a new student to the database
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // Handles HTTP DELETE requests for deleting a student from the database by ID
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    // Handles HTTP PUT requests for updating the name and/or email of a student in the database by ID
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}

