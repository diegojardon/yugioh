package com.personal.yugioh.repository;

import com.personal.yugioh.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
