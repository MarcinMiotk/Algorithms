package com.snmill.cp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class FinalSolution {

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
            System.out.println(movesToReachTargetSquare);
        }
        //     System.out.println("3");
        //      System.out.println("5");
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
        Graph graph = new Graph();

        public Game(List<Snake> snakes, List<Ladder> ladders) {
            this.snakes = snakes;
            this.ladders = ladders;
            create100vertexes();
            link100VertexesWithDices();
        }

        int movesToReachTargetSquare() {
            for (Snake snake : snakes) {
                graph.addLadderOrSnake(snake.starting, snake.ending);
            }
            for (Ladder ladder : ladders) {
                graph.addLadderOrSnake(ladder.starting, ladder.ending);
            }

            BreadthFirstSearch bfs = new BreadthFirstSearch();
            BreadthFirstSearch.Visit visit = bfs.BreadthFirstSearch(graph, 100);
            if (visit != null) {
                return visit.distance;
            } else {
                return -1;
            }
        }

        private void create100vertexes() {
            for (int v = 1; v <= 100; v++) {
                graph.createVertex(v);
            }
        }

        private void link100VertexesWithDices() {
            // there are 6 dices at the roll (1,2,3,4,5,6)
            for (int v = 1; v <= 100; v++) {
                for (int dice = 1; dice <= 6; dice++) {
                    int toVertex = v + dice;
                    if (toVertex <= 100) {
                        graph.edge(v, toVertex, dice);
                    } else {
                        graph.edge(v, v, dice);
                    }
                }
            }
        }

    }

    public static class Graph {

        private final LinkedList<Vertex> vertexes = new LinkedList<>();

        static class Vertex {

            final int id;

            public Vertex(int id) {
                this.id = id;
            }

            final LinkedList<Vertex> edges = new LinkedList<>();

            void addEdgeTo(Vertex vertex, int sequence) {
                edges.add(sequence - 1, vertex);
            }

            Vertex getEdge(int sequence) {
                return edges.get(sequence - 1);
            }
        }

        public void createVertex(int id) {
            vertexes.add(id - 1, new Vertex(id));
        }

        public void edge(int idFrom, int idTo, int sequence) {
            Vertex vFrom = vertexes.get(idFrom - 1);
            Vertex vto = vertexes.get(idTo - 1);
            vFrom.addEdgeTo(vto, sequence);
        }

        public int getSquareReachedFromByDice(int from, int dice) {
            Vertex found = vertexes.get(from - 1).edges.get(dice - 1);
            return found.id;
        }

        public Vertex getVertex(int id) {
            return vertexes.get(id - 1);
        }

        int countVertexes() {
            return vertexes.size();
        }

        void addLadderOrSnake(int from, int to) {
            Vertex vFrom = getVertex(from);
            Vertex vTo = getVertex(to);

            vertexes.forEach((Vertex t) -> {
                List<Integer> exchange = new ArrayList<>();

                for (int sequence = 0; sequence < t.edges.size(); sequence++) {
                    if (t.edges.get(sequence).id == from) {
                        exchange.add(sequence);
                    }
                }

                exchange.forEach((Integer seq) -> {
                    t.edges.set(seq, vTo);
                });
            });

            vFrom.edges.clear();
        }

        public Iterator<Vertex> all() {
            return vertexes.iterator();
        }
    }

    public static class BreadthFirstSearch {

        static class Visit {

            Visit parent = null;
            int distance = -1;
            Graph.Vertex vertex;

            public Visit(Graph.Vertex vertex) {
                this.vertex = vertex;
            }
        }

        public Visit BreadthFirstSearch(Graph graph, int targetId) {
            List<Visit> visits = new ArrayList<>(graph.countVertexes());
            Map<Integer, Visit> map = new HashMap<>();
            Iterator<Graph.Vertex> graphVertexes = graph.all();
            while (graphVertexes.hasNext()) {
                Visit v = new Visit(graphVertexes.next());
                visits.add(v);
                map.put(v.vertex.id, v);
            }

            LinkedList<Visit> queue = new LinkedList<>();
            Visit root = visits.get(0);
            root.distance = 0;
            queue.offerLast(root);

            while (!queue.isEmpty()) {
                Visit current = queue.pollFirst();
                Iterator<Graph.Vertex> edges = current.vertex.edges.iterator();
                while (edges.hasNext()) {
                    Graph.Vertex edge = edges.next();
                    Visit visit = map.get(edge.id);
                    if (visit.distance == -1) {
                        visit.distance = current.distance + 1;
                        visit.parent = current;
                        queue.offerLast(visit);

                        if (visit.vertex.id == targetId) {
                            return visit;
                        }
                    } else {
                        // I was here
                    }
                }
            }
            return null;
        }
    }

}
