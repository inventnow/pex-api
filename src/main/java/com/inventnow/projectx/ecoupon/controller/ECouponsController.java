package com.inventnow.projectx.ecoupon.controller;

import com.inventnow.projectx.ecoupon.dto.ECoupons;
import com.inventnow.projectx.ecoupon.service.ECouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecoupons")
public class ECouponsController {

    @Autowired
    private ECouponsService eCouponsService;

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ECoupons getECoupons(@PathVariable Long userId) {
        return eCouponsService.getECoupons(userId);
    }

    @PutMapping(path = "/{ecouponId}/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void activateCoupon(@PathVariable Long eCouponId, @PathVariable Long userId) {
        eCouponsService.activateECoupons(eCouponId, userId);
    }
}
