package com.snmill.cp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Graph {

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
