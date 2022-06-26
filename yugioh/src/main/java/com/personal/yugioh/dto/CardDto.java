package com.personal.yugioh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private String name;
    private String code;
    private String edition;
    private int quantity;
    private PriceDto priceDto;
}
