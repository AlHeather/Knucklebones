package com.kb;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurnTest {

    @Test
    public void scoreTest(){
        Player player = new Player(1);
        player.addRoll(1,2);
        player.addRoll(1,4);
        player.addRoll(1,6);
        //lane one score = 12
        player.addRoll(2,3);
        player.addRoll(2,3);
        //lane 2 score = 12
        player.addRoll(3,3);
        player.addRoll(3,3);
        player.addRoll(3,3);
        //lane 3 score = 27
        System.out.println(player);

        int expected = 51;
        int actual = Turn.getScore(player);

        assertEquals(expected,actual);
    }

    @Test
    public void ScoreTest2(){
        Player player = new Player(1);
        player.addRoll(1,3);
        player.addRoll(2,4);
        player.addRoll(3,5);

        int expected = 12;
        int actual = Turn.getScore(player);

        assertEquals(expected,actual);
    }
}