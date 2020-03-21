package com.inventnow.projectx.transaction.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Transaction {

    private LocalDate date;

    private TransactionType type;

    private Long points;

    private BigDecimal amount;

    private Merchant merchant;
}
