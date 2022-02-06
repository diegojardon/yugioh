package com.personal.yugioh.service.impl;

import com.personal.yugioh.service.CardBusiness;
import com.personal.yugioh.entity.Card;
import com.personal.yugioh.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardBusinessImpl implements CardBusiness {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
