package main.java.lk.ijse.crop_monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Placeholder login endpoint
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "Login Successful!";
    }

    // Placeholder signup endpoint
    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password) {
        String encodedPassword = passwordEncoder.encode(password);
        // Logic to save the user in the database
        return "Signup Successful! Encoded password: " + encodedPassword;
    }
}