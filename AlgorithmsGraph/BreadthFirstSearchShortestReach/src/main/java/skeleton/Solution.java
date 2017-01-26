package skeleton;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int numberOfQuerues = in.nextInt();
            for (int query = 0; query < numberOfQuerues; query++) {

                int numberOfNodes = in.nextInt();
                int numberOfEdges = in.nextInt();

                Solution solution = new Solution(numberOfNodes, numberOfEdges);

                for (int edge = 0; edge < numberOfEdges; edge++) {
                    int nodeFrom = in.nextInt();
                    int nodeTo = in.nextInt();

                    solution.addEdge(nodeFrom, nodeTo);
                }
                int startingNode = in.nextInt();
                List<Integer> distances = solution.solveShortestDistancesToEachOtherNodes(startingNode);
                print(distances);
            }
        }
    }

    private static void print(List<Integer> distances) {
        boolean first = true;
        for (Integer distance : distances) {
            if (!first) {
                out.print(" ");
            } else {
                first = false;
            }
            out.print(distance);
        }
        out.println();
    }

    int numberOfNodes;
    int numberOfEdges;

    protected Solution(int numberOfNodes, int numberOfEdges) {
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
    }

    static class Vertex {

        @Override
        public String toString() {
            return "Vertex{" + "id=" + id + "}";
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.id);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vertex other = (Vertex) obj;
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            return true;
        }

        private final String id;
        private final Set<Vertex> neighbours = new LinkedHashSet<>();

        private boolean visited = false;

        public Vertex(String id) {
            this.id = id;
        }

        void addNeighbour(Vertex vertex) {
            neighbours.add(vertex);
            vertex.neighbours.add(this);
        }

    }

    private final Map<String, Vertex> vertexes = new HashMap<>();

    private Vertex getOrCreate(String id) {
        Vertex v = vertexes.get(id);
        if (v == null) {
            v = new Vertex(id);
            vertexes.put(id, v);
        }
        return v;
    }

    protected List<Integer> solveShortestDistancesToEachOtherNodes(int startingNode) {
        List<Integer> distances = new ArrayList<>();

        Solution.BfsDistances aggregator = new Solution.BfsDistances();
        bfsVisiting(startingNode, (String node, String parent) -> {
            aggregator.visit(node, parent);
        });

        for (int i = 1; i <= numberOfNodes; i++) {
            if (startingNode != i) {
                Integer distance = aggregator.distanceFrom(i + "");
                if (distance <= 0) {
                    distances.add(distance);
                } else {
                    distances.add(distance * 6);
                }
            }
        }

        return distances;
    }

    interface VisitListener {

        void visited(String node, String parent);
    }

    protected void addEdge(Integer nodeFrom, Integer nodeTo) {
        Vertex first = getOrCreate(nodeFrom.toString());
        Vertex second = getOrCreate(nodeTo.toString());
        first.addNeighbour(second);
    }

    void bfsVisiting(Integer fromNode, VisitListener listener) {
        bfsVisiting(getOrCreate(fromNode.toString()), listener);
    }

    void bfsVisiting(Vertex startingVertex, VisitListener listener) {
        Queue<Vertex> stack = new LinkedList<>();    // BFS uses Queue, DFS uses Stack
        stack.offer(startingVertex);

        // VISIT
        startingVertex.visited = true;
        listener.visited(startingVertex.id, null);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.poll();

            for (Vertex children : vertex.neighbours) {
                if (!children.visited) {

                    // VISIT
                    children.visited = true;
                    listener.visited(children.id, vertex.id);

                    stack.add(children);
                }
            }

        }
    }

    static class BfsDistances {

        private final Map<String, Integer> distances = new HashMap<>();

        public void visit(String node, String parent) {
            if (parent == null) {
                distances.put(node, 0);
            } else {
                Integer distanceForParent = distances.get(parent);
                distances.put(node, distanceForParent + 1);
            }
        }

        int distanceFrom(String node) {
            return distances.getOrDefault(node, -1);
        }
    }

}
