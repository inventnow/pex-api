package com.inventnow.projectx.user.events;

import com.inventnow.projectx.customer.entity.CustomerEntity;
import com.inventnow.projectx.user.entity.CardEntity;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.repository.UserRepository;
import com.inventnow.projectx.user.service.CardsRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegistrationEventListener {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardsRegistrationService cardRegistrationService;

    @Async
    @EventListener
    public void userRegistrationListener(UserRegisteredEvent userRegisteredEvent) {
        UserEntity userEntity = userRepository.findById(userRegisteredEvent.getUserId()).get();

        CustomerEntity customerEntity = userEntity.getCustomerEntity();

        log.info("===Registering card for customer id:{}===", customerEntity.getId());
        CardEntity cardEntity = cardRegistrationService.registerNewCardToCustomer(customerEntity);


        log.info("===Send welcome email for customer id:{} with card no:{}===", customerEntity.getId(), cardEntity.getCardNo());
    }

}
