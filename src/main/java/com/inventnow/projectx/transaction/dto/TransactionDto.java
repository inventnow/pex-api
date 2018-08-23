package com.inventnow.projectx.transaction.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDto {

    private LocalDate transactionDate;

    private Long pointsEarned;

    private BigDecimal transactionAmount;

    private Merchant merchant;
}
