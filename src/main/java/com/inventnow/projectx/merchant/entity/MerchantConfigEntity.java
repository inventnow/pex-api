package com.inventnow.projectx.merchant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name = "seq_pex_merchant_config", sequenceName = "seq_pex_merchant_config", allocationSize = 1)
@Table(name = "pex_merchant_config")
public class MerchantConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_merchant_config")
    private Long id;

    private BigDecimal defaultPointConversion;

    private LocalDateTime createdon;
}
