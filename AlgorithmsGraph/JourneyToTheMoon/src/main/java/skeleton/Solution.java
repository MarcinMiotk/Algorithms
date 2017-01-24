package skeleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Solution {

    private long result;
    private long numberOfAllAstronauts;

    public void setNumberOfAllAstronauts(int numberOfAllAstronauts) {
        this.numberOfAllAstronauts = numberOfAllAstronauts;
    }

    public void addPairFromTheSameCountry(int firstAstronaut, int secondAstronaut) {
        addPairFromTheSameCountry(firstAstronaut + "", secondAstronaut + "");
    }

    public void addPairFromTheSameCountry(String firstAstronaut, String secondAstronaut) {
        Vertex first = getOrCreate(firstAstronaut);
        Vertex second = getOrCreate(secondAstronaut);
        first.addNeighbour(second);
    }

    private Vertex getOrCreate(String id) {
        Vertex v = vertexes.get(id);
        if (v == null) {
            v = new Vertex(id);
            vertexes.put(id, v);
        }
        return v;
    }

    private final Map<String, Vertex> vertexes = new HashMap<>();

    protected List<String> getVisitedVertexes() {
        List<String> visited = new ArrayList<>();

        AtomicInteger graph = new AtomicInteger(0);

        for (Vertex v : vertexes.values()) {
            dfs(v, new OnVisited() {
                @Override
                public void onVisited(Vertex vertex) {
//                    out.println("Graph " + graph.get() + " Visiting: " + vertex.id);
                    visited.add(vertex.id);
                }
            });
            graph.incrementAndGet();
        }

        return visited;
    }

    interface OnVisited {

        void onVisited(Vertex vertex);
    }

    private void dfs(Vertex parent, OnVisited listener) {
        if (!parent.visited) {
            Stack<Vertex> stack = new Stack<>();
            stack.add(parent);

            // VISIT
            parent.visited = true;
            listener.onVisited(parent);

            while (!stack.isEmpty()) {
                Vertex vertex = stack.pop();

                for (Vertex children : vertex.neighbours) {
                    if (!children.visited) {

                        // VISIT
                        children.visited = true;
                        listener.onVisited(children);

                        stack.add(children);
                    }
                }

            }
        }
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

    public void computeSolution() {
        Stack<AtomicLong> graphs = new Stack<>();
        graphs.add(new AtomicLong(0));
        for (Vertex v : vertexes.values()) {
            dfs(v, new OnVisited() {
                @Override
                public void onVisited(Vertex vertex) {
                    graphs.peek().incrementAndGet();
                }
            });
            graphs.add(new AtomicLong(0));
        }

        this.result = numberOfAllAstronauts * (numberOfAllAstronauts - 1) / 2;

        while (!graphs.isEmpty()) {
            long subGraphSize = graphs.pop().get();
            if (subGraphSize > 0) {
                long variations = subGraphSize * (subGraphSize - 1) / 2;
                this.result -= variations;
            }
        }

    }

    public long getResult() {
        return this.result;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        try (Scanner in = new Scanner(System.in)) {
            int vertexes = in.nextInt();
            int pairsToExclude = in.nextInt();
            solution.setNumberOfAllAstronauts(vertexes);
            while (in.hasNextInt()) {
                int first = in.nextInt();
                int second = in.nextInt();
                solution.addPairFromTheSameCountry(first, second);
            }
        }
        solution.computeSolution();
        System.out.print(solution.getResult());
    }
}
