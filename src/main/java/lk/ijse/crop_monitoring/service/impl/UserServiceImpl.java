package main.java.lk.ijse.crop_monitoring.service.impl;

import main.java.lk.ijse.crop_monitoring.entity.User;
import main.java.lk.ijse.crop_monitoring.repository.UserRepository;
import main.java.lk.ijse.crop_monitoring.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null);
    }
}