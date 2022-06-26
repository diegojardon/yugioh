package com.personal.yugioh.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;
    private String cardName;
    private String cardCode;
    private String cardEdition;
    private int cardQuantity;
    private float cardHighPrice;
    private float cardLowPrice;
    private float cardAveragePrice;
    private LocalDateTime lastPriceUpdate;

}
