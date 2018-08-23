package com.inventnow.projectx.transaction.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionDto {

    private Date transactionDate;

    private Long totalPoints;

    private BigDecimal totalAmount;
}
