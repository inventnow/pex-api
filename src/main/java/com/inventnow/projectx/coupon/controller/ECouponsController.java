package com.inventnow.projectx.coupon.controller;

import com.inventnow.projectx.coupon.dto.ECoupons;
import com.inventnow.projectx.coupon.service.ECouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecoupons")
public class ECouponsController {

    @Autowired
    private ECouponsService eCouponsService;

    @GetMapping(path = "/{userId}")
    public ECoupons getECoupons(@PathVariable Long userId) {
        return eCouponsService.getECoupons(userId);
    }
}
