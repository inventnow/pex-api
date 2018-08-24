package com.inventnow.projectx.ecoupon.service;

import com.inventnow.projectx.ecoupon.dto.ECoupons;

public interface ECouponsService {
    ECoupons getECoupons(Long userId);

    void activateECoupons(Long ecouponId, Long userId);
}
