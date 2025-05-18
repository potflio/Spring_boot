package com.example.demo;

import com.example.demo.EmailRequest;
import com.example.demo.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("emailRequest", new EmailRequest());
        return "email_form";
    }

    @PostMapping("/send")
    public String sendMail(@ModelAttribute EmailRequest emailRequest, Model model) {
        emailService.sendEmail(emailRequest.getEmail(), emailRequest.getSubject(), emailRequest.getMessage());
        model.addAttribute("success", "Email sent successfully!");
        return "email_form";
    }

}
