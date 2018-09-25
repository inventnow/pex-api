package com.inventnow.projectx.customer.event;

import com.inventnow.projectx.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class CustomerEventListener {

    @Autowired
    private CustomerService customerService;

    @Async
    @TransactionalEventListener
    public void customerRegistrationEventListener(CustomerRegistrationEvent customerRegistrationEvent) {
        log.info("===REGISTER CUSTOMER FOR USER ID:{}===", customerRegistrationEvent.getUserId());
        customerService.registerCustomer(customerRegistrationEvent.getUserId(),
                customerRegistrationEvent.getCustomerRegistration());

        log.info("===SEND WELCOME EMAIL FOR USER ID:{}===", customerRegistrationEvent.getUserId());

    }
}
