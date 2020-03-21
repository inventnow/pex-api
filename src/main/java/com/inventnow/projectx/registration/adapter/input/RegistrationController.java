package com.inventnow.projectx.registration.adapter.input;

import com.inventnow.projectx.registration.dto.CustomerRegistration;
import com.inventnow.projectx.transaction.controller.TransactionController;
import com.inventnow.projectx.user.dto.Promo;
import com.inventnow.projectx.user.dto.UserHomeLogin;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.service.UserBusinessService;
import com.inventnow.projectx.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1s")
public class RegistrationController {

    @Autowired
    private UserBusinessService userBusinessService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody CustomerRegistration customerRegistration) {

        userRegistrationService.registerCustomer(customerRegistration);
    }

    @PostMapping(value = {"/info"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
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
