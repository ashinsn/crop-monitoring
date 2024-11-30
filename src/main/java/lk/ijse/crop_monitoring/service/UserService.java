package main.java.lk.ijse.crop_monitoring.service;

import main.java.lk.ijse.crop_monitoring.entity.User;

public interface UserService {
    User saveUser(User user);
    User getUserByUsername(String username);
}