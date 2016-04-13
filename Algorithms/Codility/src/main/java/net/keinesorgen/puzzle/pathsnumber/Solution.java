package net.keinesorgen.puzzle.pathsnumber;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 */
public class Solution {

    enum Direction {

        RIGHT {
                    @Override
                    Position move(Position from) {
                        return new Position(from.x + 1, from.y);
                    }

                },
        DOWN {
                    @Override
                    Position move(Position from) {
                        return new Position(from.x, from.y + 1);
                    }
                };

        abstract Position move(Position from);
    }

    static class Position {

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        final int x;
        final int y;

        Position move(Direction where) {
            return where.move(this);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            boolean e1 = Objects.equals(((Position) o).x, x);
            boolean e2 = Objects.equals(((Position) o).y, y);
            return e1 && e2;
        }

    }

    static class Board {

        final int[][] surface;
        final int rows;
        final int columns;

        public Board(int[][] surface, int rows, int columns) {
            this.surface = surface;
            this.rows = rows;
            this.columns = columns;
        }

        boolean inside(Position candidate) {
            return candidate.x >= 0 && candidate.x < columns && candidate.y >= 0 && candidate.y < rows;
        }

        boolean canMove(Position candidate) {
            return inside(candidate) && surface[candidate.y][candidate.x] == 1;
        }

        boolean isTargetReached(Position candidate) {
            return (candidate.x == columns - 1) && (candidate.y == rows - 1);
        }
    }

    static class ScoutPath implements Cloneable {

        private final LinkedHashSet<Position> steps = new LinkedHashSet();
        private Position current;

        void add(Position next) {
            current = next;
            steps.add(next);
        }

        boolean contains(Position checking) {
            return steps.contains(checking);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Scout {

        final Board board;

        Scout(Board board) {
            this.board = board;
        }

        private final List<ScoutPath> succeed = new ArrayList<>();
        private final List<ScoutPath> failured = new ArrayList<>();

        private Stack<ScoutPath> bookmarks = new Stack<>();

        void onSuccess(ScoutPath path) {

        }

        void endOfAlley() throws CloneNotSupportedException {
            if (!bookmarks.isEmpty()) {
                ScoutPath path = bookmarks.pop();
                walk(path);
            }
        }

        void walk(ScoutPath path) throws CloneNotSupportedException {
            Stack<ScoutPath> possibilities = new Stack<>();
            for (Direction on : Direction.values()) {
                Position option = path.current.move(on);
                if (board.canMove(option)) {
                    ScoutPath pathOption = (ScoutPath) path.clone();
                    pathOption.add(option);
                    possibilities.add(pathOption);
                }
            }

            ScoutPath prefer = null;
            int possible = possibilities.size();
            if (possible == 0) {
                // koniec trasy
                endOfAlley();
            } else if (possible == 1) {
                // tylko jedna opcja
                prefer = possibilities.pop();
            } else if (possible > 1) {
                prefer = possibilities.pop();
                while (!possibilities.isEmpty()) {
                    bookmarks.add(possibilities.pop());
                }
            }

            if (prefer != null) {
                if (board.isTargetReached(prefer.current)) {
                    succeed.add(prefer);
                    // success
                    endOfAlley();
                } else {
                    walk(prefer);
                }
            }

        }
    }

    static int numberOfPaths(int[][] a, int M, int N) {
        Board board = new Board(a, M, N);

        Scout scout = new Scout(board);
        ScoutPath begin = new ScoutPath();
        begin.add(new Position(0, 0));
        try {
            scout.walk(begin);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        return scout.succeed.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int _a_cnt = 0, _b_cnt = 0;
        int[][] _a = new int[1000][100];
        try {
            _a_cnt = sc.nextInt();
            _b_cnt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Here: " + e.getMessage());
        }

        for (int i = 0; i < _a_cnt; i++) {
            for (int j = 0; j < _b_cnt; j++) {
                int _a_tmp = 0;
                try {
                    _a_tmp = sc.nextInt();
                } catch (Exception e) {
                }
                _a[i][j] = _a_tmp;
            }

        }
        System.out.println(numberOfPaths(_a, _b_cnt, _b_cnt));
    }
}
