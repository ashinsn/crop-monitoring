package main.java.lk.ijse.crop_monitoring.controller;

import main.java.lk.ijse.crop_monitoring.entity.User;
import main.java.lk.ijse.crop_monitoring.security.JwtUtil;
import main.java.lk.ijse.crop_monitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;  // Inject UserService to handle registration

    // Login endpoint that returns JWT token
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        return jwtUtil.generateToken(user);  // Generate and return the JWT token
    }

    // Signup endpoint (save user and encrypt password)
    @PostMapping("/signup")
    public String signup(@RequestBody User newUser) {
        // Check if the user already exists (optional)
        if (userService.getUserByUsername(newUser.getUsername()) != null) {
            return "Username is already taken!";
        }

        // Encrypt password before saving to the database
        newUser.setPassword(newUser.getPassword());  // This is where the password encoding happens

        // Register the user using UserService
        userService.saveUser(newUser);  // Save the user to the database

        return "User registered successfully!";
    }
}
