package io.jeffrey.hackkerank.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparePlayerTests {

    @Test
    public void test_001() {
        ComparePlayer.Player p1 = new ComparePlayer.Player("amy", 100);
        ComparePlayer.Player p2 = new ComparePlayer.Player("david", 100);
        ComparePlayer.Player p3 = new ComparePlayer.Player("heraldo", 50);
        ComparePlayer.Player p4 = new ComparePlayer.Player("aakansha", 75);
        ComparePlayer.Player p5 = new ComparePlayer.Player("aleksa", 150);
        ComparePlayer.Player[] players = {p1, p2, p3, p4, p5};
        Comparator<ComparePlayer.Player> comparator = new ComparePlayer.Checker();
        ComparePlayer.Player[] result = ComparePlayer.execute(players, comparator);
        assertEquals("[aleksa 150, amy 100, david 100, aakansha 75, heraldo 50]", Arrays.toString(result));

    }

}
