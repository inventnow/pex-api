package com.inventnow.projectx.merchant.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name = "seq_pex_points_promo", sequenceName = "seq_pex_points_promo", allocationSize = 1)
@Table(name = "pex_points_promo")
public class PointsPromoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_points_promo")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MERCHANT_ID")
    private MerchantEntity merchantEntity;

    private LocalDate promoStartDate;

    private LocalDate promoEndDate;

    private Long pointsMultiplication;

    private LocalDateTime createdon;
}
