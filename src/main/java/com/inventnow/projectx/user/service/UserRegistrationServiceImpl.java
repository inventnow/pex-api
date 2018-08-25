package com.inventnow.projectx.user.service;

import com.inventnow.projectx.exception.BadRequestException;
import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.entity.CustomerEntity;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.exception.UserAlreadyRegisteredException;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getEmail()) != null) {
            throw new UserAlreadyRegisteredException("Email : " + user.getEmail() + " already registered");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new BadRequestException("Password and Confirm Password not match");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEnabled(true);
        userEntity.setUsername(user.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setCreatedon(new Date());

        StringBuilder sbRole = new StringBuilder();
        for (RoleEnum roleEnum : user.getRoles()) {
            sbRole.append(roleEnum.name());
            sbRole.append(",");
        }
        sbRole.deleteCharAt(sbRole.length() - 1);
        userEntity.setRoles(sbRole.toString().trim());
        userRepository.save(userEntity);
        return user;
    }
}
