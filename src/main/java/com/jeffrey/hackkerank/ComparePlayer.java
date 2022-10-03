package com.jeffrey.hackkerank;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>Comparators are used to compare two objects.</h1><p/>
 *
 * In this challenge, you'll create a comparator and use it to sort an array.
 * The Player class is provided for you in your editor. It has 2 fields: a name
 * String and a score integer. Given an array of  Player objects, write a comparator
 * that sorts them in order of decreasing score; if 2 or more players have the same
 * score, sort those players alphabetically by name. To do this, you must create a
 * {@code Checker} class that implements the {@code Comparator} interface, then write
 * an {@code int compare(Player a, Player b)} method implementing the
 * {@code Comparator.compare(T o1, T o2)} method.<p/>
 *
 * <b>Input Format</b><br/>
 * Input from stdin is handled by the locked stub code in the solution class.
 * The first line contains an integer n, denoting the number of players.
 * Each of the <b>n</b> subsequent lines contains a player's name and score,
 * respectively.<p/>
 *
 * <b>Constraints</b><br/>
 * <ul>
 *     <li>0 <= score <=1000</li>
 *     <li>2 players can have the same name.</li>
 *     <li>Player names consist of lowercase English letters.</li>
 * </ul>
 *
 * <b>Output Format</b><br/>
 * You are not responsible for printing any output to stdout.
 * The locked stub code in Solution will create a Checker object,
 * use it to sort the Player array, and print each sorted element.<p/>
 *
 * <b>Sample Input</b><br/>
 * <pre>
 * {@code
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 * }
 * </pre>
 *
 * <b>Sample Output</b><br/>
 * <pre>
 * {@code
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 * }
 * </pre>
 */
class ComparePlayer {
    static class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return this.name + " " + this.score;
        }
    }

    static class Checker implements Comparator<Player> {
        // Write your Checker class here
        @Override
        public int compare(Player p1, Player p2) {
            if (p1.score != p2.score) {
                return (p2.score - p1.score);
            } else {
                return (p1.name.compareTo(p2.name));
            }
        }
    }

    static Player[] execute(Player [] players, Comparator<Player> comparator) {
        return solutionV1(players, comparator);
    }

    private static Player[] solutionV1(Player [] players, Comparator<Player> comparator) {
        Arrays.sort(players, comparator);
        return players;
    }
}
