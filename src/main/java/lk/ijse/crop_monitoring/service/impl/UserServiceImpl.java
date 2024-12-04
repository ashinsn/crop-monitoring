package main.java.lk.ijse.crop_monitoring.service.impl;

import main.java.lk.ijse.crop_monitoring.repository.UserRepository;  // Import your repository
import main.java.lk.ijse.crop_monitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;  // Assuming you have a UserRepository

    @Autowired
    private PasswordEncoder passwordEncoder;  // For password encryption

    // Register a new user
    @Override
    public void registerUser(String username, String password, String role) {
        // Encrypt the password before saving it
        String encryptedPassword = passwordEncoder.encode(password);

        // Create and save the user with the provided username, encrypted password, and role
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        user.setRole(role);  // Assuming User has a role attribute
        userRepository.save(user);
    }

    // Save the user to the database
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get user by username
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    // Load user by username (required by UserDetailsService)
    @Override
    public UserDetails loadUserByUsername(String username) {
        return getUserByUsername(username);
    }
}
