package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.transaction.controller.TransactionController;
import com.inventnow.projectx.user.dto.CustomerRegistration;
import com.inventnow.projectx.user.dto.Promo;
import com.inventnow.projectx.user.dto.UserHome;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.service.UserBusinessService;
import com.inventnow.projectx.user.service.UserRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1/users")
@Api(description = "Set of operation for user setting and info")
public class UserController {

    @Autowired
    private UserBusinessService userBusinessService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody CustomerRegistration customerRegistration) {

        userRegistrationService.registerCustomer(customerRegistration);
    }

    @PostMapping(value = {"/info"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get user latest info (Points, authorization, latest promo")
    public UserHome getUserInfo(OAuth2Authentication oauth2User) {
        UserEntity userEntity = userBusinessService.getUserDetails(oauth2User.getName());
        UserHome userHome = new UserHome();
        userHome.setUserId(userEntity.getId());
        userHome.setFirstName(userEntity.getFirstName());
        userHome.setLastName(userEntity.getLastName());
        userHome.setUserName(oauth2User.getName());
        userHome.setRoles(AuthorityUtils.authorityListToSet(oauth2User.getAuthorities()));
        userHome.setTotalPoints(10500L);
        List<Promo> promoList = new ArrayList<>();

        Promo promo1 = new Promo(1L, "IMAGE1");
        Promo promo2 = new Promo(2L, "IMAGE2");


        promoList.add(promo1);
        promoList.add(promo2);

        userHome.setPromos(promoList);

        userHome.add(linkTo(methodOn(TransactionController.class).getTransactions(userEntity.getId())).withRel("transactions"));
        return userHome;
    }
}
