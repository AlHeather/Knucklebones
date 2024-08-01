package com.kb;

public class Player {
    private int[] lane1;
    private int[] lane2;
    private int[] lane3;
    private int playerNumber;
    private final int MAXLANESIZE = 3;

    public Player(int playerNumber){
        this.playerNumber = playerNumber;
        lane1 = new int[MAXLANESIZE];
        lane2 = new int[MAXLANESIZE];
        lane3 = new int[MAXLANESIZE];
        for(int i = 0; i < MAXLANESIZE; i++){
            lane1[i] = 0;
            lane2[i] = 0;
            lane3[i] = 0;
        }
    }

    public int[] getLane1(){
        return lane1;
    }
    public int[] getLane2(){
        return lane2;
    }
    public int[] getLane3(){
        return lane3;
    }


    public String toString(){
        String result = "Player " + playerNumber + ":\n";
        for(int i = 0; i < MAXLANESIZE; i++){
            result += "{ " + lane1[i] + " " + lane2[i] + " " + lane3[i] + " }\n";
        }
        return result;
    }

    public void removeDice(int lane, int numToDel){
        if(lane == 1){
            this.lane1 = delInLane(numToDel, this.lane1);
            organizeLane(this.lane1);
        }else if(lane == 2){
            this.lane2 = delInLane(numToDel,this.lane2);
            organizeLane(this.lane2);
        }else{
            this.lane3 = delInLane(numToDel,this.lane3);
            organizeLane(this.lane3);
        }
    }

    private int[] delInLane(int numToDel, int[] lane){
        for(int i = 0; i < MAXLANESIZE; i++){
            if(lane[i] == numToDel){
                lane[i] = 0;
            }
        }
        return lane;
    }

    private static void organizeLane(int[] lane){
        if(lane[1] == 0){
            lane[1] = lane[2];
            lane[2] = 0;
        }
        if(lane[0] == 0){
            lane[0] = lane[1];
            lane[1] = lane[2];
            lane[2] = 0;
        }

    }

    public static boolean isLaneEmpty(int[] lane){
        boolean isEmpty = false;
        for(int x : lane){
            if(x == 0){
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    public void addRoll(int laneNumber, int rolledNumber){
        if(laneNumber == 1){
            addRollToLane(this.lane1,rolledNumber);
        }else if(laneNumber == 2){
            addRollToLane(this.lane2,rolledNumber);
        }else{
            addRollToLane(this.lane3,rolledNumber);
        }
    }

    private void addRollToLane(int[] lane, int rolledNumber){
        for(int i = 0; i < MAXLANESIZE ; i++){
            if(lane[i] == 0){
                lane[i] = rolledNumber;
                break;
            }
        }
    }



}
