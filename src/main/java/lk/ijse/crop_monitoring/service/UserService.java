package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    // Add any additional methods if needed
    // Example:
    void registerUser(String username, String password, String role);
    User saveUser(User user);
    User getUserByUsername(String username);
}