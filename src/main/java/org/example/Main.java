package org.example;

import java.util.Scanner;

public class Main {

    private static boolean playAgain = true;

    public static void main(String[] args) {

        Scanner get = new Scanner(System.in);
        Snap game;
        while(playAgain) {
            game = new Snap("Snap");
            game.startGame();
            System.out.println("Would you like to play again? Enter yes or anything else to quit");
            String response = get.nextLine().toLowerCase();
            if(!response.equals("yes")) {
                playAgain = false;
            }
            game.resetGame();
        }
        System.out.println("Thanks to play my game. Have a lovely day!");



    }
}