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
public class PriceDto {

    private float high;
    private float low;
    private float average;
    private float totalHighByQuantity;
    private float totalLowByQuantity;
    private float totalAverageByQuantity;

    private LocalDateTime lastPriceUpdate;
}
