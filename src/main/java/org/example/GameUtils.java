package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GameUtils {

    private static final String[] SYMBOLS = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static ArrayList<Card> createDeck() {

        ArrayList<Card> tempDeck = new ArrayList<>();
        while (tempDeck.size() < 51) {
            for(int i=2; i< 15; i++) {
                tempDeck.add(new Card(suits.clubs.getCode(),SYMBOLS[i-2], i ));
                tempDeck.add(new Card(suits.hearts.getCode(),SYMBOLS[i-2], i ));
                tempDeck.add(new Card(suits.diamonds.getCode(),SYMBOLS[i-2], i ));
                tempDeck.add(new Card(suits.spades.getCode(),SYMBOLS[i-2], i ));
            }
        }
        return tempDeck;
    }

    public static int getPlayersAMount () {
        Scanner scan = new Scanner(System.in);
        String players = scan.nextLine();
        int playersAmount=1;
        try {
            playersAmount = Integer.parseInt(players);
        } catch (Exception e){
        }
        if(playersAmount <2 || playersAmount >5) {
            throw new IllegalArgumentException();
        }
       return playersAmount;
    }

}
