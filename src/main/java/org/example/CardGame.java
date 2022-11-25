package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private String name;
    protected ArrayList<Card> deck;

    public CardGame(String name) {
        this.name = name;
        deck = GameUtils.createDeck();
    }

    public void getDeck() {
        for(Card card : deck) {
            System.out.println(card);
        }
    }

    public String getName() {
        return name;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public void sortDeckInNumberOrder () {
        deck.sort((card1, card2) -> {
            if(card1.getValue() > card2.getValue()) {
                return 1;
            } else if (card1.getValue() < card2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public void sortDeckInSuits () {
        sortDeckInNumberOrder();
        deck.sort(Comparator.comparing(Card::getSuit));
    }


    public Card dealCard () {
        int deckSize = deck.size();
        if(deckSize != 0) {
            Card tempCard = deck.get(deck.size()-1);
            deck.remove(deck.size()-1);
            return tempCard;

        } else {
            System.out.println("Deck complete. Creating new deck and shuffling");
            deck= GameUtils.createDeck();
            Collections.shuffle(this.deck);
            Card tempCard = deck.get(deck.size()-1);
            deck.remove(deck.size()-1);
            return tempCard;
        }
    }
}
