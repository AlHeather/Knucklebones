package com;

import java.util.Arrays;
public class kncuklebones {


    public static int[] fillArray(int[] laneToFill){
        for(int i=0; i < laneToFill.length; i += 1){
            laneToFill[i] = i;
        }
        return laneToFill;
    }

    public static void main(String[] args){
        Object[] playerOneLanes = new Object[3];
        int[] laneOne = new int[3];
        int[] laneTwo = new int[3];
        int[] laneThree = new int[3];

        fillArray(laneOne);
        fillArray(laneTwo);
        fillArray(laneThree);

        playerOneLanes[0] = Arrays.toString(laneOne);
        playerOneLanes[1] = Arrays.toString(laneTwo);
        playerOneLanes[2] = Arrays.toString(laneThree);
        System.out.println(Arrays.toString(playerOneLanes));
        System.out.println(laneOne[2]);
        System.out.println(findIndex(laneOne,2));


    }

}



