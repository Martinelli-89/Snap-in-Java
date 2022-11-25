package org.example;

public class Card {

    private String suit;
    private String symbol;
    private int value;

    public Card (String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String toString () {
        return ""+this.symbol+" of "+this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSuit() {
        return this.suit;
    }

}
