package com.personal.yugioh.entity;

import javax.persistence.*;

@Entity(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;
    private String cardName;
    private String cardCode;
    private String cardEdition;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardEdition() {
        return cardEdition;
    }

    public void setCardEdition(String cardEdition) {
        this.cardEdition = cardEdition;
    }
}
