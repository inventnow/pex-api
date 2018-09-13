package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.transaction.controller.TransactionController;
import com.inventnow.projectx.customer.dto.CustomerRegistration;
import com.inventnow.projectx.user.dto.Promo;
import com.inventnow.projectx.user.dto.UserHomeLogin;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.service.UserBusinessService;
import com.inventnow.projectx.user.service.UserRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
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
    public void registerUser(@RequestBody @Validated CustomerRegistration customerRegistration) {

        userRegistrationService.registerCustomer(customerRegistration);
    }

    @PostMapping(value = {"/info"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get user latest info (Points, authorization, latest promo")
    public UserHomeLogin getUserInfo(OAuth2Authentication oauth2User) {
        UserEntity userEntity = userBusinessService.getUserDetails(oauth2User.getName());
        UserHomeLogin userHomeLogin = new UserHomeLogin();
        userHomeLogin.setUserId(userEntity.getId());
        userHomeLogin.setFirstName(userEntity.getFirstName());
        userHomeLogin.setLastName(userEntity.getLastName());
        userHomeLogin.setUserName(oauth2User.getName());
        userHomeLogin.setRoles(AuthorityUtils.authorityListToSet(oauth2User.getAuthorities()));
        userHomeLogin.setTotalPoints(10500L);
        List<Promo> promoList = new ArrayList<>();

        Promo promo1 = new Promo(1L, "IMAGE1");
        Promo promo2 = new Promo(2L, "IMAGE2");


        promoList.add(promo1);
        promoList.add(promo2);

        userHomeLogin.setPromos(promoList);

        userHomeLogin.add(linkTo(methodOn(TransactionController.class).getTransactions(userEntity.getId())).withRel("transactions"));
        return userHomeLogin;
    }
}
