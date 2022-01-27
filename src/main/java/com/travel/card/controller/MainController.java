package com.travel.card.controller;


import com.travel.card.model.TravelHistory;
import com.travel.card.model.Wallet;
import com.travel.card.repository.TravelHistoryRepository;
import com.travel.card.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TravelHistoryRepository travelHistoryRepository;

    @GetMapping("/wallet/get")
    public ResponseEntity<Wallet> getWalletByCardNumber(@RequestParam String cardnumber) {
        Wallet wallet = walletRepository.findById(cardnumber);

        if (wallet != null) {
            return new ResponseEntity<>(wallet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/wallet")
    public ResponseEntity<String> createWallet(@RequestParam String card_number, @RequestParam String amount) {
        try {
            walletRepository.save(new Wallet(card_number, amount));
            return new ResponseEntity<>("Wallet was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/wallet/update")
    public ResponseEntity<String> updateWallet(@RequestParam String cardnumber, @RequestParam String amount) {
        Wallet _wallet = walletRepository.findById(cardnumber);

        if (_wallet != null) {
            walletRepository.update(amount,_wallet.getCardnumber());
            return new ResponseEntity<>("Wallet was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Wallet with card number=" + cardnumber, HttpStatus.NOT_FOUND);
        }
    }







}
