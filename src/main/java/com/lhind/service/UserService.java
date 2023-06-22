package com.lhind.service;

import com.lhind.model.entity.User;

import java.util.List;

public interface UserService {

    //Save Operation
    User saveUser (User user);

    //Read Operation
    List<User> allUsers();

    //Update Operation
    User updateUser(User user, Long userId);

    //Delete Operation
    void deleteUserById(Long userId);


}
