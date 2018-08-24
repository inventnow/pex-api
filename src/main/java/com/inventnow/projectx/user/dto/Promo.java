package com.inventnow.projectx.user.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Promo {

    private Long promoId;

    private String base64Image;
}
