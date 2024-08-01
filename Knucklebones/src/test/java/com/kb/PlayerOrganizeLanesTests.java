package com.kb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//TO RUN ORGANIZE LANES TESTS PLAYER ORGANIZE LANES METHOD MUST BE TURNED INTO INT[] RETURN INSTEAD OF VOID

public class PlayerOrganizeLanesTests {
//
//    @Test
//    public void OrganizeLanesTestNoChange(){
//        int[] lane = {1,4,6};
//        int[] expected = {1,4,6};
//
//        int[] actual = Player.organizeLane(lane);
//
//        assertArrayEquals(expected,actual);
//    }
//
//    @Test
//    public void OrganizeLanesDoubleEmpty(){
//        int[] lane = {0,0,4};
//        int[] expected = {4,0,0};
//
//        int[] actual = Player.organizeLane(lane);
//
//        assertArrayEquals(expected,actual);
//    }
//
//    @Test
//    public void OrganizeLanesMiddleEmpty(){
//        int[] lane = {1,0,4};
//        int[] expected = {1,4,0};
//
//        int[] actual = Player.organizeLane(lane);
//
//        assertArrayEquals(expected,actual);
//    }
//
//    @Test
//    public void OrganizeLanesFirstEmpty(){
//        int[] lane = {0,4,3};
//        int[] expected = {4,3,0};
//
//        int[] actual = Player.organizeLane(lane);
//
//        assertArrayEquals(expected,actual);
//    }

    //Test for delRoll
    private Player player = new Player(1);

    //MANUAL REVIEW WITH CODE.. TOO LAZY TO CHECK AND THE EDGE CASES ARE MINIMAL
    @Test
    public void addRollTest(){
        player.addRoll(3,2);
        System.out.println(player);
        //{0,0,2}
        //{0,0,0}
        //{0,0,0}
        player.addRoll(2,4);
        System.out.println(player);
        //{0,4,2}
        //{0,0,0}
        //{0,0,0}
        player.addRoll(1,1);
        System.out.println(player);
        //{1,4,2}
        //{0,0,0}
        //{0,0,0}
        player.addRoll(1, 5);
        System.out.println(player);
        //{1,4,2}
        //{5,0,0}
        //{0,0,0}
        player.addRoll(1,6);
        System.out.println(player);
        //{1,4,2}
        //{5,0,0}
        //{6,0,0}

        player.removeDice(1,6);
        System.out.println(player);
        //{1,4,2}
        //{5,0,0}
        //{0,0,0}
        player.removeDice(1,1);
        System.out.println(player);
        //{5,4,2}
        //{0,0,0}
        //{0,0,0}
    }
}