package main.java.lk.ijse.crop_monitoring.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    // Register a new user
    void registerUser(String username, String password, String role);

    // Save the user to the database
    User saveUser(User user);

    // Get user by username
    User getUserByUsername(String username);

    // Other service methods related to user management can be added here
}
