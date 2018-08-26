package com.inventnow.projectx.merchant.entity;

import com.inventnow.projectx.user.dto.IdentityType;
import com.inventnow.projectx.user.entity.CardEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name = "seq_pex_merchant", sequenceName = "seq_pex_merchant", allocationSize = 1)
@Table(name = "pex_merchant")
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_merchant")
    private Long id;

    private String name;

    private String emailAddress;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    private String homePhone;

    private String mobilePhone1;

    private String mobilePhone2;

    private LocalDateTime createdon;
}
