package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.model.student_model;
import com.example.demo.repository.student_repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Controller
public class student_controller {

    @Autowired
    private student_repository rep;

    private static final String UPLOAD_DIR = "/media/darkdevil/project3/lastspring/demo/src/main/resources/static/image_user";

    @GetMapping("/student_form")
    public String showForm() {
        return "student";
    }
    
    @PostMapping("/student_insert")
    public String studentInsert(
            @RequestParam String student_name,
            @RequestParam int student_age,
            @RequestParam String gender,
            @RequestParam("programming") String[] program,
            @RequestParam String city,
            @RequestParam("file") MultipartFile[] files,Model model) {
    
        String programming = String.join(", ", program);

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = UPLOAD_DIR + fileName;

                try {
                    // Save file to disk
                    file.transferTo(new File(filePath));
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("message", "File upload failed.");
                    return "student";
                }

                // Save to DB
                student_model user = new student_model();
                user.setName(student_name);
                user.setAge(student_age);
                user.setGender(gender);
                user.setCity(city);
                user.setProgramming(programming);
                user.setFile(fileName);  // store filename only

                rep.save(user);
            }
        }

        model.addAttribute("message", "Student submitted successfully!");
        return "student";

    }

    
}
