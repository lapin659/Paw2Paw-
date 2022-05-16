package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class registerController {
    @Autowired
    private UserRepository repo;

    @GetMapping({"/register","register.html"})
    public String showRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/save_user")
    public String saveUser(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "user_saved";
    }
}
