package com.sign.signinhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class Controllerv {
    @Autowired
    private repository stu;
    @Autowired
    private repositoryyy vino;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup_create")
    public String postMethodName(@RequestParam String name, @RequestParam String email, @RequestParam String psw,
            Model anu) {

        model abi = new model();
        abi.setname(name);
        abi.setpsw(psw);
        abi.setemail(email);
        if (stu.existsByemail(email)) {
            anu.addAttribute("data", "user exist");
            return "signup";
        }

        stu.save(abi);
        return "login";
    }

    @GetMapping("/login")
    public String add() {
        return "login";
    }

    @PostMapping("/login_create")
    public String postMethodName(@RequestParam String email, @RequestParam String psw, Model anu) {
        modell abi = new modell();
        abi.setemail(email);
        abi.setpsw(psw);

        if (vino.existsByemail(email)) {
            
            vino.save(abi);
            return "welcome";
        }

        anu.addAttribute("data", "email password mismatch");
        return "login";
    }
}
