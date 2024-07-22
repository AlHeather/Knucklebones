package com.kb;

import java.util.Random;

public class Turn {



    //Have Turn.rollDice give a random int between 0 and 6;
        public static int rollDice(){
            Random d6 = new Random();
            final int topBoundInclusive = 6;
            int result = d6.nextInt(topBoundInclusive);
            return result+1;
        }

        public static boolean isGameOver(Player player){
            final int MAXCOLUMNLENGTH = 3;
            int rowFilledCounter = 0;
            final int ROWSTOFILL = 3;

            for(int i = 0; i < MAXCOLUMNLENGTH; i++){
                int column1 = player.getColumn1()[i];
                int column2 = player.getColumn2()[i];
                int column3 = player.getColumn3()[i];
                if(column1 != 0 && column2 != 0 && column3 != 0){
                    rowFilledCounter++;
                }
            }
            if(rowFilledCounter == ROWSTOFILL){
                return true;
            }
            return false;
        }

        public static int scoreBuilder(Player player){


            return 0;
        }

}
