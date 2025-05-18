package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class SmsController {
    @Autowired
    private SmsService smsService;

    @GetMapping("/")
    public String form() {
        return "sms_form";
    }

    @PostMapping("/send")
    public String sendSms(@RequestParam String phone, @RequestParam String message, Model model) {
        smsService.sendSms(phone, message);
        model.addAttribute("success", "SMS Sent Successfully!");
        return "sms_form";
    }
}
