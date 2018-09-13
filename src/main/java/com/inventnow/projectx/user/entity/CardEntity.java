package com.inventnow.projectx.user.entity;

import com.inventnow.projectx.customer.entity.CustomerEntity;
import com.inventnow.projectx.user.dto.CardStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name = "seq_pex_card", sequenceName = "seq_pex_card", allocationSize = 1)
@Table(name = "pex_card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_card")
    private Long id;

    private String cardNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private LocalDateTime createdon;
}
