package com.inventnow.projectx.user.entity;

import com.inventnow.projectx.user.dto.IdentityType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name = "seq_customers", sequenceName = "seq_customers", allocationSize = 1)
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customers")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CARD_ID")
    private List<CardEntity> cards;

    private String firstName;

    private String lastName;

    private String cityOfBirth;

    private Date dateOfBirth;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
}
