package com.kb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public abstract class Turn {

    public static int getDiceRoll() {
        Random dice = new Random();
        int x = dice.nextInt(6);
        return x + 1;
    }

    public static int getScore(Player player) {
        Map<Integer, Integer> lane1ScoreMap = getScoreMap(player.getLane1());
        Map<Integer, Integer> lane2ScoreMap = getScoreMap(player.getLane2());
        Map<Integer, Integer> lane3ScoreMap = getScoreMap(player.getLane3());

        int scoreLane1 = calculateFromMap(lane1ScoreMap);
        int scoreLane2 = calculateFromMap(lane2ScoreMap);
        int scoreLane3 = calculateFromMap(lane3ScoreMap);

        int score = scoreLane1 + scoreLane2 + scoreLane3;
        return score;
    }

    private static Map<Integer, Integer> getScoreMap(int[] lane) {
        Map<Integer, Integer> scoreMap = new HashMap<>();

        for (int x : lane) {
            if (scoreMap.containsKey(x)) {
                scoreMap.put(x, scoreMap.get(x) + 1);
            } else {
                scoreMap.put(x, 1);
            }
        }
        return scoreMap;
    }

    private static int calculateFromMap(Map<Integer, Integer> map) {
        int score = 0;
        for (int x : map.keySet()) {
            int base = 0;
            for (int i = 0; i < map.get(x); i++) {
                base += x;
            }
            score += base * map.get(x);
        }
        return score;
    }


    public static boolean isGameOver(Player player) {
        boolean isGameOver = false;
        boolean isLaneOneFull = isLaneFull(player.getLane1());
        boolean isLaneTwoFull = isLaneFull(player.getLane2());
        boolean isLaneThreeFull = isLaneFull(player.getLane3());

        if (isLaneOneFull && isLaneTwoFull && isLaneThreeFull) {
            isGameOver = true;
        }
        return isGameOver;
    }

    private static boolean isLaneFull(int[] lane){
        boolean isFull = true;
        for(int x : lane){
            if(x == 0){
                isFull = false;
            }
        }
        return isFull;
    }


}
