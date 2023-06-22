package com.lhind.service.impl;

import com.lhind.model.entity.User;
import com.lhind.repository.UserRepository;
import com.lhind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //Save Operation - CREATE - C
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //Read Operation - READ - R
    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    //Update Operation - UPDATE - U
    @Override
    public User updateUser(User userRequest, Long userId) {
        User user;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            // This means that we have to do an update as the user is currently registered on the database
            user = userOptional.get();
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setId(userRequest.getId());
        } else {
            // This means that we have to create a new user.
            user = new User();
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setId(userRequest.getId());
        }
        return userRepository.save(user);
    }

    //Delete Operation - DELETE -D
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
