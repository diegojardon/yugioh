package com.personal.yugioh.persistence.repository;

import com.personal.yugioh.persistence.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByCardCode(String cardCode);

}
