// com/example/demo/controller/UserRestController.java
package com.example.demo;

import com.example.demo.User;
import com.example.demo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/submit")
    public User submitForm(@RequestBody User user) {
        return userRepository.save(user);
    }
}
