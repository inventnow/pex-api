package com.inventnow.projectx.user.service;

import com.google.common.collect.Lists;
import com.inventnow.projectx.registration.dto.CustomerRegistration;
import com.inventnow.projectx.registration.event.CustomerRegistrationEvent;
import com.inventnow.projectx.exception.BadRequestException;
import com.inventnow.projectx.exception.NotFoundException;
import com.inventnow.projectx.merchant.entity.MerchantEntity;
import com.inventnow.projectx.merchant.repository.MerchantRepository;
import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.dto.MerchantUserRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.dto.UserInfo;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.exception.UserAlreadyRegisteredException;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public UserEntity registerUser(User user) {
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
        userEntity.setCreatedon(LocalDateTime.now());

        StringBuilder sbRole = new StringBuilder();
        for (RoleEnum roleEnum : user.getRoles()) {
            sbRole.append(roleEnum.name());
            sbRole.append(",");
        }
        sbRole.deleteCharAt(sbRole.length() - 1);
        userEntity.setRoles(sbRole.toString().trim());
        return userRepository.save(userEntity);
    }


    @Override
    public void registerMerchantUser(MerchantUserRegistration merchantUserRegistration) {
        Optional<MerchantEntity> merchantEntity = merchantRepository.findById(merchantUserRegistration.getMerchantId());
        if (!merchantEntity.isPresent()) {
            throw new NotFoundException("Merchant Entity ID:" + merchantUserRegistration.getMerchantId() + " not found");
        }
        UserInfo userInfo = merchantUserRegistration.getUser();

        UserEntity userEntity = registerUser(userInfo, Lists.newArrayList(merchantUserRegistration.getRole()));
        userEntity.setMerchantEntity(merchantEntity.get());
        userRepository.save(userEntity);
    }

    @Override
    public void registerCustomer(CustomerRegistration customerRegistration) {
        UserInfo userInfo = customerRegistration.getUser();

        UserEntity savedUser = registerUser(userInfo, Lists.newArrayList(RoleEnum.CUSTOMER));

        userRepository.save(savedUser);

        applicationEventPublisher.publishEvent(new CustomerRegistrationEvent(customerRegistration, savedUser.getId()));
    }

    private UserEntity registerUser(UserInfo userInfo, List<RoleEnum> roles) {
        User user = new User();
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        user.setEmail(userInfo.getEmail());
        user.setRoles(roles);
        user.setPassword(userInfo.getPassword());
        user.setConfirmPassword(userInfo.getConfirmPassword());

        return registerUser(user);
    }

}
