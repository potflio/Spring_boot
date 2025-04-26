package com.example.ajax_api.controller;

import com.example.ajax_api.model.model;
import com.example.ajax_api.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controller {

    @Autowired
    private repository stu;

    @PostMapping("/add/")
    public String addStudent(@RequestBody model student) {
        stu.save(student);
        return "Student added successfully";
    }

    @GetMapping("/list")
    public List<model> getAllStudents() {
        return stu.findAll();
    }

    @GetMapping("/students/")
    public List<model> getStudentsByAge(@RequestParam int age) {
        return stu.findByAge(age);  // Select by age
    }

    @PostMapping("/update/{id}/")
    public String updateStudent(@PathVariable Long id, @RequestBody model updatedData) {
        Optional<model> optionalStudent = stu.findById(id);
        if (optionalStudent.isPresent()) {
            model student = optionalStudent.get();
            student.setName(updatedData.getName());
            student.setAge(updatedData.getAge());
            stu.save(student);  // Save the updated student
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }

    @PostMapping("/delete/{id}/")
    public String deleteStudent(@PathVariable Long id) {
        if (stu.existsById(id)) {
            stu.deleteById(id);  // Delete student by ID
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
