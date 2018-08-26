package com.inventnow.projectx.user.entity;

import com.inventnow.projectx.merchant.entity.MerchantEntity;
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
import java.time.LocalDateTime;

@Entity
@Table(name = "pex_user")
@SequenceGenerator(name = "seq_pex_user", sequenceName = "seq_pex_user", allocationSize = 1)
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_user")
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    private String roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customerEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MERCHANT_ID")
    private MerchantEntity merchantEntity;

    private LocalDateTime createdon;
}
