package com.sql1.sql1;

import com.sql1.sql1.student_model;
import com.sql1.sql1.student_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User_controller {

    @Autowired
    private student_rep stu;

    @GetMapping("student_form")
    public String form(){
        return "User";
    }

    @PostMapping("/student")
     public String subfan(@RequestParam String email, @RequestParam String password) {
       student_model std=new student_model();
       std.setEmail(email);
       std.setPassword(password);
       stu.save(std);
       return "redirect:/student_form";
    }
}
