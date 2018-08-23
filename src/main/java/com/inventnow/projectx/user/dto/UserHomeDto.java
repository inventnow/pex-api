package com.inventnow.projectx.user.dto;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.Set;

@Data
public class UserHomeDto extends ResourceSupport {

    private Long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private Long totalPoints;

    private Set<String> roles;

    private List<PromoDto> promos;
}
