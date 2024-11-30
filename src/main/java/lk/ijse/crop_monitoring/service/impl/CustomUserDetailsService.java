package main.java.lk.ijse.crop_monitoring.service.impl;


import main.java.lk.ijse.crop_monitoring.entity.User;
import main.java.lk.ijse.crop_monitoring.repository.UserRepository;
import main.java.lk.ijse.crop_monitoring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Return a Spring Security User object, which includes username, password, and roles
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getName()) // Assuming Role has a 'name' field
                .build();
    }

    @Override
    public void registerUser(String username, String password, String role) {
        // Example: Logic to register a new user
        // You can implement the registration logic here (e.g., saving the user to the database)
    }

    @Override
    public User saveUser(User user) {
        // Logic for saving a user (e.g., calling userRepository.save())
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        // Logic to retrieve user by username
        return userRepository.findByUsername(username).orElse(null);
    }
}
