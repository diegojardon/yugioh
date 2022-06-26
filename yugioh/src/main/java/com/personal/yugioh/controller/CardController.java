package com.personal.yugioh.controller;

import com.personal.yugioh.dto.CardDto;
import com.personal.yugioh.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/yugioh")
public class CardController {

    private final CardService cardService;

    @GetMapping("/card/{cardCode}")
    public ResponseEntity<CardDto> getYugiohCardByCode(@PathVariable("cardCode") String cardCode,
                                                       @RequestParam("updatePrice") boolean updatePrice){
        return new ResponseEntity<>(cardService.getCardInfoByCode(cardCode, updatePrice), HttpStatus.OK);
    }

}
