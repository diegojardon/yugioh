package com.personal.yugioh.service.impl;

import com.personal.yugioh.common.client.YugiohAPIClient;
import com.personal.yugioh.service.CardBusiness;
import com.personal.yugioh.entity.Card;
import com.personal.yugioh.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardBusinessImpl implements CardBusiness {

    private final CardRepository cardRepository;

    private final YugiohAPIClient yugiohAPIClient;

    @Override
    public List<Card> getAllCards() {

        List<Card> cards = cardRepository.findAll();

        Mono<String> response = yugiohAPIClient.getYugiohCardPrice("http://yugiohprices.com/api/price_for_print_tag/" + cards.get(0).getCardCode());
        response.subscribe(System.out::println);


        return cards;
    }
}
