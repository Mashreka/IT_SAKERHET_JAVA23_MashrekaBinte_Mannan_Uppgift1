package com.example.deliveryService.service;

import com.example.deliveryService.model.User;
import com.example.deliveryService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Hash the password before saving
        String hashedPassword = PasswordUtils.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return user;
    }


    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
