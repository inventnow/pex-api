package com.inventnow.projectx.transaction.controller;

import com.google.common.collect.Lists;
import com.inventnow.projectx.transaction.dto.TransactionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    @GetMapping("/{userId}")
    public List<TransactionDto> getTransactions(@PathVariable Long userId) {

        return Lists.newArrayList();
    }
}
