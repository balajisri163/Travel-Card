package com.travel.card.repository;

import com.travel.card.model.Wallet;

public interface WalletRepository {
    int save(Wallet wallet);

    int update(String amount,String cardnumber);

    Wallet findById(String cardnumber);

}
