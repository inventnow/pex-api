package com.inventnow.projectx.ecoupon.controller;

import com.inventnow.projectx.ecoupon.dto.ECoupons;
import com.inventnow.projectx.ecoupon.service.ECouponsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecoupons")
@Api(description = "Set of operation for eCoupons")
public class ECouponsController {

    @Autowired
    private ECouponsService eCouponsService;

    @GetMapping(path = "/{userId}")
    @ApiOperation("Returns existing eCoupon list for specific user, return Http Status 404 if does not exist")
    @ResponseStatus(HttpStatus.OK)
    public ECoupons getECoupons(@PathVariable Long userId) {
        return eCouponsService.getECoupons(userId);
    }
}
