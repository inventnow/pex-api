package com.inventnow.projectx.customer.event;

import com.inventnow.projectx.customer.dto.CustomerRegistration;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.springframework.context.ApplicationEvent;

@Value
@Getter
@ToString
public class CustomerRegistrationEvent extends ApplicationEvent {

    private CustomerRegistration customerRegistration;

    private Long userId;

    public CustomerRegistrationEvent(CustomerRegistration customerRegistration, Long userId) {
        super(userId);
        this.customerRegistration = customerRegistration;
        this.userId = userId;
    }

}
