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



        //If a single player has all 3 rows filled.
        //return true and end the game
        public static boolean isGameOver(Player player){
            final int MAXCOLUMNLENGTH = 3;
            int rowFilledCounter = 0;
            final int ROWSTOFILL = 3;

            for(int i = 0; i < MAXCOLUMNLENGTH; i++){
                //grab all values in a row
                int column1 = player.getColumn1()[i];
                int column2 = player.getColumn2()[i];
                int column3 = player.getColumn3()[i];
                //if none are 0 add to row counter
                if(column1 != 0 && column2 != 0 && column3 != 0){
                    rowFilledCounter++;
                }
            }
            //if row counter is maxed out. return true
            if(rowFilledCounter == ROWSTOFILL){
                return true;
            }
            //else false
            return false;
        }

        //Build score
        //if a number appears twice, value * 4
        //if it appears three times, value * 9
        //else score = value
        public static int scoreBuilder(Player player){


            return 0;
        }

}
