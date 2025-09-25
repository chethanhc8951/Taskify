package com.Taskify.Taskify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Taskify.Taskify.model.User;
import com.Taskify.Taskify.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public void registerUser(User user) {
        // Logic to register the user

        userRepository.save(user);
    }

    // Add this method
    
    public boolean verifyUser(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());

        // check if user exists and password matches
        return  dbUser != null && dbUser.getPassword().equals(user.getPassword());
    }

}
