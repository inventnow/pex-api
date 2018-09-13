package com.inventnow.projectx.customer.entity;

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
@SequenceGenerator(name = "seq_pex_customer", sequenceName = "seq_pex_customer", allocationSize = 1)
@Table(name = "pex_customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_customer")
    private Long id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardEntity> card = new ArrayList<>();

    private String firstName;

    private String lastName;

    private String cityOfBirth;

    private LocalDate dateOfBirth;

    private String emailAddress;

    @Enumerated(EnumType.STRING)
    private IdentityType identityType;

    private String identityNo;

    private String addressStreet;

    private String addressCity;

    private String addressPostalCode;

    private String homePhone;

    private String mobilePhone1;

    private String mobilePhone2;

    private LocalDateTime createdon;
}
