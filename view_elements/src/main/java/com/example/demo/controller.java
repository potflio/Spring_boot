package com.example.demo;

import com.example.demo.Stumodel; 
import com.example.demo.repository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


@Controller // You missed this annotation!
public class controller {

    @Autowired
    private repository rep;

    @GetMapping("/student_form")
    public String showForm() {
        return "student_form"; 
    }

    @GetMapping("/student_details")
    public String showDetails(Model model) {
        List<Stumodel> list = rep.findAll();
        model.addAttribute("students", list);
        return "student_details";
    }

    @GetMapping("/student_edit")
    public String showEdit() {
        return "student_edit";
    }

    @GetMapping("/student_delete")
    public String showDelete() {
        return "student_delete";
    }

    @PostMapping("/submit")
    public String submitForm(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String city,
            @RequestParam("skill") String[] skillarray) {

        String skill = String.join(", ", skillarray);
        Stumodel user = new Stumodel();
        user.setName(name);
        user.setGender(gender);
        user.setCity(city);
        user.setSkills(skill);

        rep.save(user);

        return "redirect:/student_form"; 
    }
}
