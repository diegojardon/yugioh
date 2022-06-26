package com.personal.yugioh.service;

import com.personal.yugioh.common.client.YugiohAPIClient;
import com.personal.yugioh.dto.CardDto;
import com.personal.yugioh.dto.PriceDto;
import com.personal.yugioh.dto.YugiohAPIResponse;
import com.personal.yugioh.persistence.entity.Card;
import com.personal.yugioh.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CardService{

    private final CardRepository cardRepository;

    private final YugiohAPIClient yugiohAPIClient;

    public CardDto getCardInfoByCode(String code, boolean updatePrice) {
        Card cardFound = cardRepository.findByCardCode(code);
        System.out.println("updatePrice: " + updatePrice);
        if(updatePrice){
            System.out.println("Calling Yugioh API for " + cardFound.getCardCode() + "...");
            YugiohAPIResponse response = yugiohAPIClient.getYugiohCardPrice(cardFound.getCardCode());
            saveCardPricesIntoDB(response, cardFound);
        }

        return cardToCardDto(cardFound);
    }

    private void saveCardPricesIntoDB(YugiohAPIResponse response, Card cardToUpdate){
        System.out.println("Updating prices into DB...");
        cardToUpdate.setCardHighPrice(response.getData().getPrice_data().getPrice_data().getData().getPrices().getHigh());
        cardToUpdate.setCardLowPrice(response.getData().getPrice_data().getPrice_data().getData().getPrices().getLow());
        cardToUpdate.setCardAveragePrice(response.getData().getPrice_data().getPrice_data().getData().getPrices().getAverage());
        cardToUpdate.setLastPriceUpdate(LocalDateTime.now());
        cardRepository.save(cardToUpdate);
    }

    private CardDto cardToCardDto(Card card){
        return CardDto.builder()
                .name(card.getCardName())
                .code(card.getCardCode())
                .edition(card.getCardEdition())
                .quantity(card.getCardQuantity())
                .priceDto(PriceDto.builder()
                                  .high(card.getCardHighPrice())
                                  .low(card.getCardLowPrice())
                                  .average(card.getCardAveragePrice())
                                  .totalHighByQuantity(card.getCardHighPrice() * card.getCardQuantity())
                                  .totalLowByQuantity(card.getCardLowPrice() * card.getCardQuantity())
                                  .totalAverageByQuantity(card.getCardAveragePrice() * card.getCardQuantity())
                                  .lastPriceUpdate(card.getLastPriceUpdate())
                                  .build())
                .build();
    }
}
