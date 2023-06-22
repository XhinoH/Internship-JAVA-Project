package com.lhind.service;

import com.lhind.model.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {

    //Save Operation
    UserDetails saveUserDetails (UserDetails user);

    //Read Operation
    List<UserDetails> allUsersDetails();

    //Update Operation
    UserDetails updateUserDetails(UserDetails user, Long userId);

    //Delete Operation
    void deleteUserDetailsById(Long userId);


}
