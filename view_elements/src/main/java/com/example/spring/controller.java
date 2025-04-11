package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class controller {

    @Autowired
    private repository rep;

    @GetMapping("/student_form")
    public String showForm() {
        return "index";
    }

    @PostMapping("/student_detail_submit")
    public String submitForm(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String city,
            @RequestParam("skill") String[] skillarray) {

        String skill = String.join(", ", skillarray);
        model user = new model();
        user.setName(name);
        user.setGender(gender);
        user.setCity(city);
        user.setSkills(skill);

        rep.save(user);

        return "redirect:/student_form";
    }

    @GetMapping("/view")
    public String view(Model kl) {
        List<model> list = rep.findAll();
        kl.addAttribute("datas", list);
        return "student_view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long pass, Model anu) {
        model student = rep.findById(pass).orElse(null);
        anu.addAttribute("datas", student);
        return "edit";
    }

    @PostMapping("/student_update")
    public String updateStudent(@RequestParam Long id,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String city,
            @RequestParam("skill") String[] skillarray) {

        model student = rep.findById(id).orElse(null);
        if (student != null) {
            student.setName(name);
            student.setGender(gender);
            student.setCity(city);
            student.setSkills(String.join(", ", skillarray));
            rep.save(student);
        }

        return "redirect:/view";
    }


    @GetMapping("/delete")
    public String showDelete(@RequestParam Long remove) {
        rep.deleteById(remove);
        return "redirect:/view";
    }
}