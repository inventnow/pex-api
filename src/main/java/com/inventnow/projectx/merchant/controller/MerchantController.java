package com.inventnow.projectx.merchant.controller;

import com.inventnow.projectx.merchant.dto.CreatePromo;
import com.inventnow.projectx.merchant.dto.Merchant;
import com.inventnow.projectx.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMerchant(@RequestBody Merchant merchant) {
        merchantService.createMerchant(merchant);
    }

    @PostMapping("/promo")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPromo(@RequestBody CreatePromo createPromo) {
        merchantService.addPromoMerchant(createPromo);
    }
}
