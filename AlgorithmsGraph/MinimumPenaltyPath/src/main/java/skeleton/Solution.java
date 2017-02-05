package skeleton;

import com.sun.org.apache.xpath.internal.operations.Bool;

import static java.lang.System.out;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.*;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

                int vertices = in.nextInt();
                int edges = in.nextInt();

                Solution solution = new Solution(vertices);

                for (int edge = 0; edge < edges; edge++) {
                    int vertexFirst = in.nextInt();
                    int vertexSecond = in.nextInt();
                    int cost = in.nextInt();

                    solution.addEdge(vertexFirst, vertexSecond, cost);
                }

                int source = in.nextInt();
                int destination = in.nextInt();

                int penalty = solution.minimumPenaltyPath(source, destination);
                out.print(penalty);
        }
    }

    private final int vertices;
    private final Map<Integer, Vertex> collection = new HashMap<>();

    protected Solution(int nodes) {
        this.vertices = nodes;
    }

    public Vertex getOrCreate(int node) {
        Vertex result = collection.get(node);
        if(result==null) {
            result = new Vertex(node);
            collection.put(node, result);
        }
        return result;
    }

    private int minimalPenalty = Integer.MAX_VALUE;

    public void addEdge(int vertexFirst, int vertexSecond, int cost) {
        Vertex first = getOrCreate(vertexFirst);
        Vertex second = getOrCreate(vertexSecond);

        Edge edgeForFirst = new Edge(second, cost);
        Edge edgeForSecond = new Edge(first, cost);

        first.addEdge(edgeForFirst);
        second.addEdge(edgeForSecond);
    }

    public int minimumPenaltyPath(int source, int destination) {
        Solution.Vertex sourceVertex = getOrCreate(source);
        Solution.Vertex destinationVertex = getOrCreate(destination);

        Dijkstra dijkstra = new Dijkstra();
        DijkstraStructures dijkstraStructures = new DijkstraStructures();
        dijkstraStructures.setDestinationToReach(destinationVertex.id);

        Consumer<Vertex> processNeighbours = (vertex) -> {
            dijkstra.process(
                    vertex,
                    dijkstraStructures::onVisit,
                    dijkstraStructures::parentAssign,
                    dijkstraStructures::costAssign,
                    dijkstraStructures::removeCostForVertex,
                    dijkstraStructures::isParentOf,
                    Solution.DijkstraStructures::isFirstCostBetterThanSecond,
                    Solution::sumBitwiseOR);
        };



        // begin

        processNeighbours.accept(sourceVertex);
        while(!dijkstraStructures.isFinished()) {
            Integer next = dijkstraStructures.getBestVertexInCostsTable(Solution.DijkstraStructures::isFirstCostBetterThanSecond);
            Vertex nextVertex = getOrCreate(next);
            processNeighbours.accept(nextVertex);
        }
        if(dijkstraStructures.doesPathToDestinationCanBeFound()) {
            return dijkstraStructures.getFinalCost();
        } else {
            return -1;
        }
    }


    static Integer sumBitwiseOR(Integer first, Integer second) {
        return first | second;
    }

    static Integer sum(Integer first, Integer second) {
        return first+second;
    }



    static class Edge {
        Vertex destination;
        int cost;

        public Edge(Vertex destination, int cost) {
        this.destination = destination;
        this.cost = cost;
        }
    }

    static class Vertex {

        private final int id;
        private final List<Edge> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public int countEdges() {
            return edges.size();
        }

        public void addEdge(Edge edgeToAdd) {
            edges.add(edgeToAdd);
        }

        public void removeLoops() {
            List<Edge> toRemove = new ArrayList<>();
            for(Edge edge : edges) {
                if(edge.destination.id == id) {
                    toRemove.add(edge);
                }
            }
            edges.removeAll(toRemove);
        }

        public void mergeMultipleEdges(BiFunction<Integer, Integer, Boolean> isFirstBetter) {
            // szukanie duplikatow
            Map<Integer, List<Edge>> mostProfitableVertexes = new HashMap<>();
            for(Edge edge : edges) {
                List<Edge> edgesForThisDestination = mostProfitableVertexes.get(edge.destination.id);
                if(edgesForThisDestination==null) {
                    edgesForThisDestination = new ArrayList<>();
                    mostProfitableVertexes.put(edge.destination.id, edgesForThisDestination);
                }
                edgesForThisDestination.add(edge);
            }
            for(List<Edge> edgesForSameDestination : mostProfitableVertexes.values()) {
                // merge
                if(edgesForSameDestination.size()>1) {
                    Edge mostProfitableEdge = edgesForSameDestination.get(0);
                    for(Edge toCompare : edgesForSameDestination) {
                        if(isFirstBetter.apply(toCompare.cost, mostProfitableEdge.cost)) {
                            mostProfitableEdge = toCompare;
                        }
                    }
                    edgesForSameDestination.clear();
                    edgesForSameDestination.add(mostProfitableEdge);
                }
            }
            edges.clear();
            for(Integer id : mostProfitableVertexes.keySet()) {
                List<Edge> merged = mostProfitableVertexes.get(id);
                edges.addAll(merged);   // only one
            }
        }


        public int costTo(int destination) {
            for(Edge e : edges) {
                if(e.destination.id == destination) {
                    return e.cost;
                }
            }
            return -1;
        }
    }


    static class DijkstraStructures {

        private final List<Integer> visited  = new ArrayList<>();
        private final Map<Integer, Integer> parents = new HashMap<>();
        private final Map<Integer, Integer> costs = new HashMap<>();
        private List<Integer> finalPath;

        static public Boolean isFirstCostBetterThanSecond(Integer first, Integer second) {
            return first<second;
        }

        List<Integer> getVisited() {
            return visited;
        }

        public Integer getParentFor(int vertex) {
            return parents.get(vertex);
        }

        public void onVisit(int vertex) {
            visited.add(vertex);
        }

        public void parentAssign(int vertex, int parent) {
            parents.put(vertex, parent);
        }

        public Integer getPathCostFor(int vertex) {
            return costs.get(vertex);
        }

        public boolean costAssign(int sourceVertex, int destinationVertex, int cost, BiFunction<Integer, Integer, Integer> costsAccumulation) {
            Integer sourceCost = costs.get(sourceVertex);
            if(sourceCost==null) {
                sourceCost = 0;
            }
            int candidateCost = costsAccumulation.apply(sourceCost, cost);
            int existingDestinationCost = costs.getOrDefault(destinationVertex, Integer.MAX_VALUE);
            if(candidateCost<existingDestinationCost) {
                costs.put(destinationVertex, candidateCost);
                //out.println("Cost assigning "+destinationVertex+" cost "+candidateCost+" in "+sourceVertex);
                return true;
            } else {
                return false;
            }
        }

        public void setCostByTest(int vertex, int cost) {
            costs.put(vertex, cost);
        }

        public void setVisitedByTest(int vertex) {
            visited.add(vertex);
        }

        public void setParentByTest(int vertex, int parent) {
            parents.put(vertex, parent);
        }

        public void removeCostForVertex(int vertex) {
            costs.remove(vertex);
        }

        public int getPathCostsSize() {
            return costs.size();
        }

        public boolean isParentOf(Integer vertex, Integer parent) {
            Integer maybeParent = parents.get(vertex);
            if(maybeParent!=null && maybeParent==parent) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFinished() {
            if(costs.isEmpty()) {
                return true;
            } else {
                if(costs.size()==1) {
                    return costs.keySet().contains(destinationToReach);
                }
            }
            return false;
        }

        public Integer getFinalCost() {
            return costs.values().iterator().next();
        }

        public List<Integer> getFinalPath() {
            if(!isFinished()) {
                throw new IllegalStateException("Destination ("+destinationToReach+") is not reached yet");
            }
            List<Integer> result = new ArrayList<>();
            Integer current = costs.keySet().iterator().next();
            result.add(current);
            do {
                Integer parent = parents.get(current);
                if (parent != null) {
                    result.add(parent);
                    current = parent;
                } else {
                    break;
                }
            } while(current!=null);

            return result;
        }

        private Integer destinationToReach;

        public void setDestinationToReach(int destinationToReach) {
            this.destinationToReach = destinationToReach;
        }

        public boolean doesPathToDestinationCanBeFound() {
            return !costs.isEmpty();
        }

        public Integer getBestVertexInCostsTable(BiFunction<Integer, Integer, Boolean> isFirstBetterThanSecond) {
            final AtomicReference<Integer> bestVertex = new AtomicReference<>();
            final AtomicReference<Integer> lowerCost = new AtomicReference<>();
            costs.forEach((vertex, cost) -> {
                if(lowerCost.get()!=null) {
                    if(isFirstBetterThanSecond.apply(cost, lowerCost.get())) {
                        lowerCost.set(cost);
                        bestVertex.set(vertex);
                    }
                } else {
                    lowerCost.set(cost);
                    bestVertex.set(vertex);
                }
            });
            return bestVertex.get();
        }
    }

    @FunctionalInterface
    interface ParentDiscovering {
        void assign(int vertex, int parent);
    }

    @FunctionalInterface
    interface CostUpdating {
        boolean assign(int sourceVertex, int destinationVertex, int cost, BiFunction<Integer, Integer, Integer> costsAccumulation);
    }

    static class Dijkstra {

        public void process(
                Vertex vertex,
                IntConsumer onVisit,
                ParentDiscovering parent,
                CostUpdating costs,
                IntConsumer costsRemoving,
                BiFunction<Integer, Integer, Boolean> isParent,
                BiFunction<Integer, Integer, Boolean> isFirstCostBetterThanSecond,
                BiFunction<Integer, Integer, Integer> costsAccumulation) {
            adaptForDijkstraAlgorithm(vertex, isFirstCostBetterThanSecond);

            for(Edge edge : vertex.edges) {
                if(!isParent.apply(vertex.id, edge.destination.id) && costs.assign(vertex.id, edge.destination.id, edge.cost, costsAccumulation)) {
                    parent.assign(edge.destination.id, vertex.id);
                }
            }
            costsRemoving.accept(vertex.id);
            onVisit.accept(vertex.id);
        }


        public void adaptForDijkstraAlgorithm(Vertex vertex, BiFunction<Integer, Integer, Boolean> isFirstBetter) {
            // remove all loops
            removeLoops(vertex);
            mergeMultipleEdges(vertex, isFirstBetter);
        }

        private void mergeMultipleEdges(Vertex vertex, BiFunction<Integer, Integer, Boolean> isBetter) {
            vertex.mergeMultipleEdges(isBetter);
        }

        private void removeLoops(Vertex vertex) {
            vertex.removeLoops();
        }
    }
}
