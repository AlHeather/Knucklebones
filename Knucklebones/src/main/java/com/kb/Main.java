package com.kb;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    //Use the same user input scanner for everything

    //Create new Players
    private Player player1 = new Player(1);
    private Player player2 = new Player(2);
    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run(){
        while(true){
            printBoard();

            int roll = Turn.getDiceRoll();

            System.out.printf("Player 1 rolled " + roll + " ");
            boolean isLaneValid = false;
            int lane = 0;
            while(!isLaneValid){
                lane = selectLane();
                if(lane == 1){
                    isLaneValid = Player.isLaneEmpty(player1.getLane1());
                }else if(lane == 2){
                    isLaneValid = Player.isLaneEmpty(player1.getLane2());
                }else if (lane == 3){
                    isLaneValid = Player.isLaneEmpty(player1.getLane3());
                }
                if(!isLaneValid){
                    System.out.println("Enter a lane that has a '0'");
                }
            }

            player1.addRoll(lane,roll);
            player2.removeDice(lane,roll);

            if(Turn.isGameOver(player1)){
                break;
            }

            printBoard();

            roll = Turn.getDiceRoll();


            System.out.printf("Player 2 rolled " + roll + " ");
            isLaneValid = false;
            lane = 0;
            while(!isLaneValid) {
                lane = selectLane();
                if(lane == 1){
                    isLaneValid = Player.isLaneEmpty(player2.getLane1());
                }else if(lane == 2){
                    isLaneValid = Player.isLaneEmpty(player2.getLane2());
                }else if(lane == 3){
                    isLaneValid = Player.isLaneEmpty(player2.getLane3());
                }
                if(!isLaneValid){
                    System.out.println("enter a lane with a '0'");
                }
            }

            player2.addRoll(lane,roll);
            player1.removeDice(lane,roll);

            if(Turn.isGameOver(player2)){
                break;
            }
        }

        System.out.println("FINAL BOARD:");
        printBoard();

        int player1Score = Turn.getScore(player1);
        int player2Score = Turn.getScore(player2);

        System.out.println("Player 1 " + player1Score + " points");
        System.out.println("Player 2 " + player2Score + " points");

        if(player1Score < player2Score){
            System.out.println("Player 1 wins!");
        }else{
            System.out.println("Player 2 wins!");
        }
    }

    private void printBoard(){
        System.out.println(player1);
        System.out.println(player2);
    }

    private int selectLane(){
        boolean isValidNumber = false;
        int result = 0;
        while(!isValidNumber) {
            System.out.println("enter lane to place dice (1-3, left to right)");
            String strInt = userInput.nextLine();
            try{
                int parsedInt = Integer.parseInt(strInt);
                if(parsedInt <= 3 && parsedInt > 0 ){
                    result = parsedInt;
                    isValidNumber = true;
                }
            }catch(NumberFormatException e){
                System.out.println("Give number as a digit");
            }
        }
        return result;
    }
}
