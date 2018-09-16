package com.inventnow.projectx.merchant.service;

import com.inventnow.projectx.exception.NotFoundException;
import com.inventnow.projectx.merchant.dto.CreatePromo;
import com.inventnow.projectx.merchant.dto.Merchant;
import com.inventnow.projectx.merchant.entity.MerchantEntity;
import com.inventnow.projectx.merchant.entity.PointsPromoEntity;
import com.inventnow.projectx.merchant.repository.MerchantRepository;
import com.inventnow.projectx.merchant.repository.PointsPromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private PointsPromoRepository pointsPromoRepository;

    @Override
    public void createMerchant(Merchant merchant) {
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(merchant.getName());
        merchantEntity.setAddressCity(merchant.getAddressCity());
        merchantEntity.setAddressPostalCode(merchant.getAddressPostalCode());
        merchantEntity.setAddressCity(merchant.getAddressCity());
        merchantEntity.setAddressStreet(merchant.getAddressStreet());
        merchantEntity.setEmailAddress(merchant.getEmailAddress());
        merchantEntity.setHomePhone(merchant.getHomePhone());
        merchantEntity.setMobilePhone1(merchant.getMobilePhone1());
        merchantEntity.setMobilePhone1(merchant.getMobilePhone2());
        merchantEntity.setCreatedon(LocalDateTime.now());

        merchantRepository.save(merchantEntity);
    }

    @Override
    public void addPromoMerchant(CreatePromo createPromo) {
        Optional<MerchantEntity> merchantEntity = merchantRepository.findById(createPromo.getMerchantId());
        if (!merchantEntity.isPresent()) {
            throw new NotFoundException("Merchant ID:{}" + createPromo.getMerchantId() + " not found");
        }

        PointsPromoEntity pointsPromoEntity = new PointsPromoEntity();
        pointsPromoEntity.setMerchantEntity(merchantEntity.get());
        pointsPromoEntity.setPointsMultiplication(createPromo.getPointMultiplications());
        pointsPromoEntity.setPromoStartDate(createPromo.getPromoStartDate());
        pointsPromoEntity.setPromoEndDate(createPromo.getPromoEndDate());
        pointsPromoEntity.setCreatedon(LocalDateTime.now());

        pointsPromoRepository.save(pointsPromoEntity);
    }
}
