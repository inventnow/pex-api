package com.inventnow.projectx.user.service;

import com.google.common.collect.Lists;
import com.inventnow.projectx.exception.BadRequestException;
import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.dto.CustomerRegistration;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.dto.UserInfo;
import com.inventnow.projectx.user.entity.CustomerEntity;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.events.NewUserRegistrationEvent;
import com.inventnow.projectx.user.exception.UserAlreadyRegisteredException;
import com.inventnow.projectx.user.repository.CustomerRepository;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        userEntity.setCreatedon(new Date());

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
    @Transactional
    public void registerCustomer(CustomerRegistration customerRegistration) {

        UserInfo userInfo = customerRegistration.getUser();

        UserEntity savedUser = registerCustomerUser(userInfo);

        CustomerEntity customerEntity = mapToCustomerEntity(customerRegistration, savedUser);

        customerRepository.save(customerEntity);

        savedUser.setCustomerEntity(customerEntity);

        userRepository.save(savedUser);

        applicationEventPublisher.publishEvent(new NewUserRegistrationEvent(savedUser.getId()));
    }

    private UserEntity registerCustomerUser(UserInfo userInfo) {
        User user = new User();
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        user.setEmail(userInfo.getEmail());
        user.setRoles(Lists.newArrayList(RoleEnum.CUSTOMER));
        user.setPassword(userInfo.getPassword());
        user.setConfirmPassword(userInfo.getConfirmPassword());

        return registerUser(user);
    }

    private CustomerEntity mapToCustomerEntity(CustomerRegistration customerRegistration, UserEntity savedUser) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(savedUser.getFirstName());
        customerEntity.setLastName(savedUser.getLastName());
        customerEntity.setEmailAddress(savedUser.getUsername());
        customerEntity.setAddressCity(customerRegistration.getAddressCity());
        customerEntity.setAddressStreet(customerRegistration.getAddressStreet());
        customerEntity.setAddressPostalCode(customerRegistration.getAddressPostalCode());
        customerEntity.setCityOfBirth(customerRegistration.getCityOfBirth());
        customerEntity.setDateOfBirth(customerRegistration.getDateOfBirth());
        customerEntity.setHomePhone(customerRegistration.getHomePhone());
        customerEntity.setMobilePhone1(customerRegistration.getMobilePhone1());
        customerEntity.setMobilePhone2(customerRegistration.getMobilePhone2());

        customerEntity.setIdentityType(customerRegistration.getIdentityType());
        customerEntity.setIdentityNo(customerRegistration.getIdentityNo());
        customerEntity.setCreatedon(new Date());
        return customerEntity;
    }
}
