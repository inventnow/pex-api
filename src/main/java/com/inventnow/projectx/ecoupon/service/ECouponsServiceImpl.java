package com.inventnow.projectx.ecoupon.service;

import com.inventnow.projectx.ecoupon.dto.ECoupons;
import com.inventnow.projectx.ecoupon.repository.MockECouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ECouponsServiceImpl implements ECouponsService {

    @Autowired
    private MockECouponsRepository eCouponsRepository;

    public ECoupons getECoupons(Long userId) {
        return eCouponsRepository.eCoupons();
    }
}
