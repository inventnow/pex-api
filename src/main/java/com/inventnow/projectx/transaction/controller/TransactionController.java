package com.inventnow.projectx.transaction.controller;

import com.google.common.collect.Lists;
import com.inventnow.projectx.transaction.dto.Merchant;
import com.inventnow.projectx.transaction.dto.Transaction;
import com.inventnow.projectx.transaction.dto.TransactionType;
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
    public List<Transaction> getTransactions(@PathVariable Long userId) {

        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.of(2018, 05, 01));
        transaction.setPoints(500L);
        transaction.setType(TransactionType.EARNED);
        transaction.setAmount(new BigDecimal(25000));
        Merchant merchant = new Merchant();
        merchant.setId(500000L);
        merchant.setMerchantName("Starbuck");
        transaction.setMerchant(merchant);


        Transaction transaction2 = new Transaction();
        transaction2.setDate(LocalDate.of(2018, 05, 02));
        transaction2.setPoints(500L);
        transaction2.setType(TransactionType.EARNED);
        transaction2.setAmount(new BigDecimal(25000));
        transaction2.setMerchant(merchant);


        Transaction transaction3 = new Transaction();
        transaction3.setDate(LocalDate.of(2018, 07, 11));
        transaction3.setPoints(300L);
        transaction3.setType(TransactionType.REDEEM);
        transaction3.setAmount(new BigDecimal(25000));
        Merchant merchant2 = new Merchant();
        merchant2.setId(500001L);
        merchant2.setMerchantName("Ny.Suharti");
        transaction3.setMerchant(merchant2);

        return Lists.newArrayList(transaction, transaction2,transaction3);
    }
}
