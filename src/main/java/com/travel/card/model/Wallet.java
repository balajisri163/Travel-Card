package com.travel.card.model;

public class Wallet {
    private String cardnumber;
    private String amount;

    public Wallet() {

    }

    public Wallet(String cardnumber, String amount) {
        this.cardnumber = cardnumber;
        this.amount = amount;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
