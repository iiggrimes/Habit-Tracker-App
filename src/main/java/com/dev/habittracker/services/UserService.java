package com.dev.habittracker.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dev.habittracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails lo

}
