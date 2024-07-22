package com.kb;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Create both players
        Player player1 = new Player();
        Player player2 = new Player();

        //Testing how add roll works.

        player1.addRoll(3, player2.getColumn1());
        player2.addRoll(5, player2.getColumn2());
        player2.addRoll(4, player2.getColumn2());
        player2.addRoll(1, player2.getColumn3());
        player1.addRoll(6, player2.getColumn1());
        player1.addRoll(2, player2.getColumn1());


        System.out.println(player1.getColumn1()[0]);


        //Start Game
        //Display lanes first
        System.out.println("Player 1:");
        player1.printBoard();
        System.out.println("");
        System.out.println("Player 2:");
        player2.printBoard();


        //Loop Gameplay

        while (true) {
            //Player 1 roll and lane select
            //Must generate roll first
            int generatedRoll = Turn.rollDice();

            //loop until valid lane.
            while (true) {
                System.out.println("Player 1 rolled: " + generatedRoll);
                System.out.println("Pick a column 1-3 (left to right)");
                int lanePick = Integer.parseInt((scanner.nextLine()));
                if (lanePick == 1) {
                    player1.addRoll(generatedRoll, player1.getColumn1());
                    player2.deleteLane(generatedRoll, player2.getColumn1());
                    break;
                } else if (lanePick == 2) {
                    player1.addRoll(generatedRoll, player1.getColumn2());
                    player2.deleteLane(generatedRoll, player2.getColumn2());
                    break;
                } else if (lanePick == 3) {
                    player1.addRoll(generatedRoll, player1.getColumn3());
                    player2.deleteLane(generatedRoll, player2.getColumn3());
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }

            //fix player2 lanes
            player2.organizeLanes();

            //Display board state
            System.out.println("Player 1:");
            player1.printBoard();
            System.out.println("");
            System.out.println("Player 2:");
            player2.printBoard();

            //Check if player 1 ended the game
            if (Turn.isGameOver(player1)) {
                break;
            }

            //generate player 2 roll
            generatedRoll = Turn.rollDice();

            while(true){
                System.out.println("Player 2 rolled: " + generatedRoll);
                System.out.println("Pick a column 1-3 (left to right)");
                int lanePicked = Integer.parseInt(scanner.nextLine());
                if(lanePicked==1){
                    player2.addRoll(generatedRoll,player2.getColumn1());
                    player1.deleteLane(generatedRoll,player1.getColumn1());
                    break;
                }else if(lanePicked==2){
                    player2.addRoll(generatedRoll,player2.getColumn2());
                    player1.deleteLane(generatedRoll,player1.getColumn2());
                    break;
                }else if(lanePicked==3){
                    player2.addRoll(generatedRoll,player2.getColumn3());
                    player1.deleteLane(generatedRoll,player1.getColumn3());
                    break;
                }else{
                    System.out.println("invalid input");
                }
            }

            //clean up player 1 lanes
            player1.organizeLanes();

            //Display board state
            System.out.println("Player 1:");
            player1.printBoard();
            System.out.println("");
            System.out.println("Player 2:");
            player2.printBoard();

            //check if player 2 ended the game
            if(Turn.isGameOver(player2)){
                break;
            }

        }

    }
}
