package com.personal.yugioh.business.impl;

import com.personal.yugioh.business.CardBusiness;
import com.personal.yugioh.entity.Card;
import com.personal.yugioh.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardBusinessImpl implements CardBusiness {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
