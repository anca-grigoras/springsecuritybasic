package com.bank.controller;

import com.bank.model.Cards;
import com.bank.model.Customer;
import com.bank.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getId());
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
}
