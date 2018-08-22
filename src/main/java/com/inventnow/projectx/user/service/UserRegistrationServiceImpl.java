package com.inventnow.projectx.user.service;

import com.inventnow.projectx.exception.BadRequestException;
import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.dto.UserDto;
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
    public UserDto registerUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getEmail()) != null) {
            throw new UserAlreadyRegisteredException("Email : " + userDto.getEmail() + " already registered");
        }
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new BadRequestException("Password and Confirm Password not match");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEnabled(true);
        userEntity.setUsername(userDto.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setCreatedon(new Date());

        StringBuilder sbRole = new StringBuilder();
        for (RoleEnum roleEnum : userDto.getRoles()) {
            sbRole.append(roleEnum.name());
            sbRole.append(",");
        }
        sbRole.deleteCharAt(sbRole.length() - 1);
        userEntity.setRoles(sbRole.toString().trim());
        userRepository.save(userEntity);
        return userDto;
    }
}
