package com.inventnow.projectx.transaction.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Merchant {

    @ApiModelProperty(value = "Merchant id" ,example = "10000")
    private Long id;

    @ApiModelProperty(value = "Merchant name" ,example = "Starbuck")
    private String merchantName;
}
