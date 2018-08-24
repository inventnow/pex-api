package com.inventnow.projectx.transaction.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Transaction {

    @ApiModelProperty(value = "Transaction Date", example = "2018-08-17")
    private LocalDate date;

    @ApiModelProperty(value = "Transaction Type", example = "EARNED", allowableValues = "EARNED,REDEEM")
    private TransactionType type;

    @ApiModelProperty(value = "Points", example = "100")
    private Long points;

    @ApiModelProperty(value = "Transaction amount", example = "1000000")
    private BigDecimal amount;

    @ApiModelProperty(value = "Merchant info")
    private Merchant merchant;
}
