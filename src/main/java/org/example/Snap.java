package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap  extends CardGame{

    public ArrayList<Player> players = new ArrayList<>();
    public int indexUserTurn = 0;
    public Card dealtCard;
    public boolean gameEnd = false;

    public Snap(String name) {
        super(name);
    }

    public void addPlayers (int amountPlayers) {
        Scanner getName = new Scanner(System.in);
        do {
            System.out.println("Enter player name");
            try {
                String name =getName.nextLine().toUpperCase();
                players.add(new Player(name));
                System.out.println("Player " + (players.size()) + " added");
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Please enter a valid user name");
            }
        } while (players == null || players.size() < amountPlayers);
    }

    public int scanPlayerAmount () {
        int amount=-1;
        while (amount == -1) {
            System.out.println("How many players are going to play?");
            try {
                amount = GameUtils.getPlayersAMount();
            } catch (Exception e) {
                System.err.println("Please enter a valid amount of players. Between 2 and 5");
            }
        }
        return amount;
    }

    public void updateTurn () {
        if(indexUserTurn < (players.size() -1)) {
            indexUserTurn++;
        } else {
            indexUserTurn=0;
        }
    }

    public void resetGame ()  {

        players = new ArrayList<>();
        indexUserTurn=0;
        gameEnd=false;

    }

    public void startGame() {
        CardGame snap = new CardGame("Snap");
        Scanner scan = new Scanner(System.in);
        snap.shuffleDeck();
        System.out.println("Welcome to " + snap.getName());
        addPlayers(scanPlayerAmount());
        System.out.println("Great, we are ready to start!");
        System.out.println("Press enter to start");
        String nextTurn = scan.nextLine();
        dealtCard = snap.dealCard();
        System.out.println(dealtCard.toString());
        while(!gameEnd) {
            System.out.println("\nPlayer turn: "+ players.get(indexUserTurn).getName());
            System.out.println("Symbol to match: "+ dealtCard.getSymbol());
            System.out.println("Press enter to get new card");
            nextTurn = scan.nextLine();
            Card tempCard = snap.dealCard();
            System.out.println(tempCard.toString());
            if(dealtCard.getSymbol().equals(tempCard.getSymbol())) {
                System.out.println("Snap or loose baby... you have two seconds!");
                long time = System.currentTimeMillis();
                long end = time + 2000;
                String snapToWin = "";
                snapToWin = scan.nextLine();
                time = System.currentTimeMillis();
                if(snapToWin.toLowerCase().equals("snap") && time < end) {
                    System.out.println(players.get(indexUserTurn).getName() + " won!");
                    gameEnd = true;
                } else {
                    System.out.println(players.get(indexUserTurn).getName() + " you are too slow to win! Eliminated");
                    players.remove(indexUserTurn);
                    if(players.size() == 1) {
                        System.out.println("\n"+players.get(indexUserTurn).getName() + " is the last one to stand!");
                        gameEnd= true;
                    }
                    updateTurn();
                    dealtCard=tempCard;
                }
            } else {
                updateTurn();
                dealtCard=tempCard;
            }
        }
    }

}
