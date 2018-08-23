package com.inventnow.projectx.user.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class PromoDto {

    private Long promoId;

    private String base64Image;
}
