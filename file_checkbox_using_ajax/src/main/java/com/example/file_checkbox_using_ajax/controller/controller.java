package com.example.file_checkbox_using_ajax.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.example.file_checkbox_using_ajax.repository.*;
import com.example.file_checkbox_using_ajax.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class controller {

    @Autowired
    private repository repo;

    // This will render the HTML form page
    @GetMapping("/")
    public String formPage() {
        return "form"; // Loads form.html (stored in src/main/resources/templates)
    }

    // Handles the form submission (AJAX)
    @PostMapping("/submit")
    public ResponseEntity<String> handleForm(
        @RequestParam String name,
        @RequestParam List<String> skills,
        @RequestParam("files") MultipartFile[] files) {

        String skillList = String.join(",", skills);
        List<String> uploadedFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    Path path = Paths.get("uploads/" + fileName);
                    Files.createDirectories(path.getParent()); // Ensure the upload folder exists
                    Files.write(path, file.getBytes());
                    uploadedFiles.add(fileName);
                } catch (IOException e) {
                    return ResponseEntity.status(500).body("File upload failed");
                }
            }
        }

        // Create user and save data to database
        model user = new model();
        user.setName(name);
        user.setSkills(skillList);
        user.setFileNames(String.join(",", uploadedFiles));
        repo.save(user);

        return ResponseEntity.ok("Saved successfully");
    }
}
