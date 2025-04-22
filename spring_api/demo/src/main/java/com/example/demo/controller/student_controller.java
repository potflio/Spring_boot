package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.student_model;
import com.example.demo.repository.student_repository;

@RestController
@RequestMapping("/api/students")
public class student_controller {

    @Autowired
    private student_repository stu;

    @PostMapping
    public student_model createStudent(@RequestBody student_model student) {
        return stu.save(student);  // Fixed return type and parameter
    }

    @GetMapping
    public List<student_model> getAllStudents() {
        return stu.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<student_model> getStudentById(@PathVariable Long id) {
        return stu.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<student_model> updateStudent(@PathVariable Long id, @RequestBody student_model newStudent) {
        return stu.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            return ResponseEntity.ok(stu.save(student));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        stu.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
