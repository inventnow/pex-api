package com.inventnow.projectx.coupon.repository;

import com.google.common.collect.Lists;
import com.inventnow.projectx.coupon.dto.ECoupon;
import com.inventnow.projectx.coupon.dto.ECoupons;
import org.springframework.stereotype.Repository;

@Repository
public class MockECouponsRepository {


    public ECoupons eCoupons() {

        ECoupons eCoupons = new ECoupons();
        ECoupon eCoupon = new ECoupon();
        eCoupon.setMerchantId(1);
        eCoupon.setPointsTime(10);

        ECoupon eCoupon2 = new ECoupon();
        eCoupon2.setMerchantId(2);
        eCoupon2.setPointsTime(5);

        ECoupon eCoupon3 = new ECoupon();
        eCoupon3.setMerchantId(3);
        eCoupon3.setPointsTime(5);

        eCoupons.setActivated(Lists.newArrayList(eCoupon, eCoupon2));
        eCoupons.setDeactivated(Lists.newArrayList(eCoupon3));

        return eCoupons;
    }
}
