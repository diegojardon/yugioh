package com.personal.yugioh.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;
    private String cardName;
    private String cardCode;
    private String cardEdition;
    private Float cardPrice;

}
