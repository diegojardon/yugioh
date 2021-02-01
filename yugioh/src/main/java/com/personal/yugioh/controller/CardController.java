package com.personal.yugioh.controller;

import com.personal.yugioh.business.CardBusiness;
import com.personal.yugioh.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardBusiness cardBusiness;

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getYugiohCards(){
        return new ResponseEntity<>(cardBusiness.getAllCards(), HttpStatus.OK);
    }

}
