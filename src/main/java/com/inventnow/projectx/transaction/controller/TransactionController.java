package com.inventnow.projectx.transaction.controller;

import com.google.common.collect.Lists;
import com.inventnow.projectx.transaction.dto.Merchant;
import com.inventnow.projectx.transaction.dto.TransactionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    @GetMapping("/{userId}")
    public List<TransactionDto> getTransactions(@PathVariable Long userId) {

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionDate(LocalDate.of(2018, 05, 01));
        transactionDto.setPointsEarned(500L);
        transactionDto.setTransactionAmount(new BigDecimal(25000));
        Merchant merchant = new Merchant();
        merchant.setId(5000000L);
        merchant.setMerchantName("Starbuck");
        transactionDto.setMerchant(merchant);


        TransactionDto transactionDto2 = new TransactionDto();
        transactionDto2.setTransactionDate(LocalDate.of(2018, 07, 11));
        transactionDto2.setPointsEarned(500L);
        transactionDto2.setTransactionAmount(new BigDecimal(25000));
        Merchant merchant2 = new Merchant();
        merchant2.setId(5000001L);
        merchant2.setMerchantName("Ny.Suharti");
        transactionDto2.setMerchant(merchant2);

        return Lists.newArrayList(transactionDto, transactionDto2);
    }
}
