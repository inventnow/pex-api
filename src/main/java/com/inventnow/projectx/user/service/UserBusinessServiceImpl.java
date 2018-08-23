package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserDetails(String username) {
        return userRepository.findByUsername(username);
    }
}
