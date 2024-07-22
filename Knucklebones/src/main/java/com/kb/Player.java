package com.kb;

public class Player {
    //set columns to check dice against
    private int[] column1 = new int[3];
    private int[] column2 = new int[3];
    private int[] column3 = new int [3];

    //Constants

    //Make getters.. I don't think i need setters
    public int[] getColumn1() {
        return column1;
    }

    public int[] getColumn2() {
        return column2;
    }

    public int[] getColumn3() {
        return column3;
    }

    //Constructor. make everything 0
    public Player(){
        final int MAXCOLUMNSIZE = 3;
        for(int i = 0; i < MAXCOLUMNSIZE; i++){
            column1[i] = 0;
            column2[i] = 0;
            column3[i] = 0;
        }
    }

    //Check for number rolled in lane place. delete copies of that on the other player
    public void deleteLane(int numberRolled, int[] columnUsed){
        for(int i = 0; i < columnUsed.length; i++){
            if(columnUsed[i] == numberRolled){
                columnUsed[i] = 0;
            }
        }
    }

    //put 0's in the back, move everything else forward.
    public void organizeLanes(){
        if((column1[0] == 0 && (column1[1] > 0 || column1[2] > 0))
        || (column1[1] == 0 && column1[2] > 0)){
            if(column1[0] == 0 ) {
                column1[0] = column1[1];
            }
            column1[1] = column1[2];
            column1[2] = 0;
        }
        if((column2[0] == 0 && (column2[1] > 0 || column2[2] > 0))
                || (column2[1] == 0 && column2[2] > 0)){
            if(column2[0] == 0 ) {
                column2[0] = column2[1];
            }
            column2[1] = column2[2];
            column2[2] = 0;
        }
        if((column3[0] == 0 && (column3[1] > 0 || column3[2] > 0))
                || (column3[1] == 0 && column3[2] > 0)){
            if(column3[0] == 0 ) {
                column3[0] = column3[1];
            }
            column3[1] = column3[2];
            column3[2] = 0;
        }
    }

    //add roll to the first non 0
    public void addRoll(int valueRolled, int[] columnSelected){
        for(int i = 0; i < columnSelected.length; i++){
            if(columnSelected[i] == 0){
                columnSelected[i] = valueRolled;
                break;
            }
        }
    }

    //Print Board state
    public void printBoard(){
        final int MAXCOLUMNSIZE = 3;
        for(int i=0; i < MAXCOLUMNSIZE; i++){
            int column1 = this.column1[i];
            int column2 = this.column2[i];
            int column3 = this.column3[i];
            System.out.println(column1 + " | " + column2 + " | " + column3);
        }
    }



}
