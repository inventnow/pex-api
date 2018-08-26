package com.inventnow.projectx.user.events;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
@EqualsAndHashCode
public class UserRegisteredEvent extends ApplicationEvent {

    private static final long serialVersionUID = 6706828499102210469L;

    private Long userId;

    public UserRegisteredEvent(Long userId) {
        super(userId);
        this.userId = userId;
    }
}
