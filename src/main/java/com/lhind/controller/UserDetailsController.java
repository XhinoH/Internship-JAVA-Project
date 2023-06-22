package com.lhind.controller;

import com.lhind.model.entity.UserDetails;
import com.lhind.service.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userDetails")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Create a new userDetails
    @PostMapping("/")
    public UserDetails createUser(@RequestBody UserDetails user) {
        return userDetailsService.saveUserDetails(user);
    }

    // Retrieve all users
    @GetMapping("/")
    public List<UserDetails> getAllUsers() {
        return userDetailsService.allUsersDetails();
    }

    // Update an existing user by ID
    @PutMapping("/{userId}")
    public UserDetails updateUser(@RequestBody UserDetails user, @PathVariable Long userId) {
        return userDetailsService.updateUserDetails(user, userId);
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userDetailsService.deleteUserDetailsById(userId);
    }
}
