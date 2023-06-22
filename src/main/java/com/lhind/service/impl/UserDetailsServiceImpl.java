package com.lhind.service.impl;

import com.lhind.service.UserDetailsService;
import com.lhind.model.entity.UserDetails;
import com.lhind.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository repository;

    @Override
    public UserDetails saveUserDetails(UserDetails user) {
        return repository.save(user);
    }

    @Override
    public List<UserDetails> allUsersDetails() {
        return repository.findAll();
    }

    @Override
    public UserDetails updateUserDetails(UserDetails user, Long userId) {
        UserDetails userFromDB = repository.findById(userId).orElse(null);
            if(userFromDB != null){
                repository.save(user);
            }
            return user;
    }

    @Override
    public void deleteUserDetailsById(Long userId) {
        repository.deleteById(userId);
    }
}
