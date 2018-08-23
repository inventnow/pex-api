package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.transaction.controller.TransactionController;
import com.inventnow.projectx.user.dto.PromoDto;
import com.inventnow.projectx.user.dto.UserHomeDto;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.service.UserBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1/user")
@Api(description = "Set of operation for user setting and info")
public class UserController {

    @Autowired
    private UserBusinessService userBusinessService;

    @PostMapping(value = {"/info"}, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get user latest info (Points, authorization, latest promo")
    public UserHomeDto getUserInfo(OAuth2Authentication oauth2User) {
        UserEntity userEntity = userBusinessService.getUserDetails(oauth2User.getName());

        UserHomeDto userHomeDto = new UserHomeDto();
        userHomeDto.setUserId(userEntity.getId());
        userHomeDto.setFirstName(userEntity.getFirstName());
        userHomeDto.setLastName(userEntity.getLastName());
        userHomeDto.setUserName(oauth2User.getName());
        userHomeDto.setRoles(AuthorityUtils.authorityListToSet(oauth2User.getAuthorities()));
        userHomeDto.setTotalPoints(10500L);
        List<PromoDto> promoDtoList = new ArrayList<>();

        PromoDto promo1 = new PromoDto(1L, "IMAGE1");
        PromoDto promo2 = new PromoDto(2L, "IMAGE2");


        promoDtoList.add(promo1);
        promoDtoList.add(promo2);

        userHomeDto.setPromos(promoDtoList);

        userHomeDto.add(linkTo(methodOn(TransactionController.class).getTransactions(userEntity.getId())).withRel("transactions"));
        return userHomeDto;
    }

}
