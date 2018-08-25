package com.inventnow.projectx.user.entity;

import com.inventnow.projectx.user.dto.CardStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@SequenceGenerator(name = "seq_cards", sequenceName = "seq_cards", allocationSize = 1)
@Table(name = "cards")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cards")
    private Long id;

    private String cardNo;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
}
