package com.inventnow.projectx.customer.event;

import com.inventnow.projectx.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerEventListener {

    @Autowired
    private CustomerService customerService;

    @Async
    @EventListener
    public void customerRegistrationEventListener(CustomerRegistrationEvent customerRegistrationEvent) {
        log.info("===REGISTER CUSTOMER FOR USER ID:{}===", customerRegistrationEvent.getUserId());
        customerService.registerCustomer(customerRegistrationEvent.getUserId(),
                customerRegistrationEvent.getCustomerRegistration());
    }
}
