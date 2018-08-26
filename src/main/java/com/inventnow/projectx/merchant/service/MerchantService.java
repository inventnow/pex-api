package com.inventnow.projectx.merchant.service;

import com.inventnow.projectx.merchant.dto.CreatePromo;
import com.inventnow.projectx.merchant.dto.Merchant;

public interface MerchantService {

    void createMerchant(Merchant merchant);

    void addPromoMerchant(CreatePromo createPromo);

}
