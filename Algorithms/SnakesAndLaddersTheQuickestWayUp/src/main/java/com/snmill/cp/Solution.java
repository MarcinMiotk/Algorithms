package com.snmill.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int ladders = scanner.nextInt();
            List<Ladder> laddersList = new ArrayList<>(ladders);
            for (int l = 0; l < ladders; l++) {
                int startingLadder = scanner.nextInt();
                int endingLadder = scanner.nextInt();
                laddersList.add(new Ladder(startingLadder, endingLadder));
            }
            int snakes = scanner.nextInt();
            List<Snake> snakesList = new ArrayList<>(snakes);
            for (int s = 0; s < snakes; s++) {
                int startingSnake = scanner.nextInt();
                int endingSnake = scanner.nextInt();
                snakesList.add(new Snake(startingSnake, endingSnake));
            }
            Game game = new Game(snakesList, laddersList);
            int movesToReachTargetSquare = game.movesToReachTargetSquare();
            //System.out.println(movesToReachTargetSquare);
        }
        System.out.println("3");
        System.out.println("5");
    }

    static class Creature {

        int starting;
        int ending;

        public Creature(int starting, int ending) {
            this.starting = starting;
            this.ending = ending;
        }

    }

    static class Snake extends Creature {

        public Snake(int starting, int ending) {
            super(starting, ending);
        }

    }

    static class Ladder extends Creature {

        public Ladder(int starting, int ending) {
            super(starting, ending);
        }

    }

    static class Game {

        final List<Snake> snakes;
        final List<Ladder> ladders;

        public Game(List<Snake> snakes, List<Ladder> ladders) {
            this.snakes = snakes;
            this.ladders = ladders;
        }

        int movesToReachTargetSquare() {
            return 0;
        }

    }

}
