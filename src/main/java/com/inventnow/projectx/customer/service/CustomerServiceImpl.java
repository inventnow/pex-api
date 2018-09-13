package com.inventnow.projectx.customer.service;

import com.inventnow.projectx.customer.dto.CustomerRegistration;
import com.inventnow.projectx.customer.entity.CustomerEntity;
import com.inventnow.projectx.customer.repository.CustomerRepository;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void registerCustomer(Long userId, CustomerRegistration customerRegistration) {

        UserEntity savedUser = userRepository.findById(userId).orElse(null);

        CustomerEntity customerEntity = mapToCustomerEntity(customerRegistration, savedUser);

        customerRepository.save(customerEntity);

        savedUser.setCustomerEntity(customerEntity);

        userRepository.save(savedUser);
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
        customerEntity.setCreatedon(LocalDateTime.now());
        return customerEntity;
    }
}
