package skeleton;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.out;

public class Solution2 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int vertices = in.nextInt();
            int edges = in.nextInt();
            Collection<Dijkstra.UndirectedEdge<Integer, Integer>> allEdges = new ArrayList<>();
            for (int edge = 0; edge < edges; edge++) {
                int vertexFirst = in.nextInt();
                int vertexSecond = in.nextInt();
                int cost = in.nextInt();
                allEdges.add(new Dijkstra.UndirectedEdge<>(vertexFirst, vertexSecond, cost));
            }
            int source = in.nextInt();
            int target = in.nextInt();

            // ----

            List<Integer> all = new ArrayList<>();
            for(int v=1; v<=vertices; v++) {
                all.add(v);
            }


            Iterator allVertices = all.iterator();

            Integer penalty = new Dijkstra<Integer, Integer>(Solution2::zero, Solution2::bitwiseOR).minimumPath(allEdges.iterator(), source, target, allVertices);
            out.print(Optional.ofNullable(penalty).orElse(-1));
        }
    }

    static Integer zero() {
        return 0;
    }

    static Integer bitwiseOR(Integer first, Integer second) {
        if(first==null || second==null) {
            return null;
        } else {
            return first | second;
        }
    }

    static class Dijkstra<V, W> {

        static class UndirectedEdge<V, W> {
            private V from;
            private V to;
            private W weight;

            UndirectedEdge(V first, V second, W weigh) {
                this.from = first;
                this.to = second;
                this.weight = weigh;
            }
        }

        static class Vertex<V, W> {
            final V id;
            final Collection<Adjacence<V, W>> adjacences;

            Vertex(V id) {
                this.id = id;
                this.adjacences = new ArrayList<>();
            }

            void addAdjacence(Adjacence<V,W> adjacence) {
                this.adjacences.add(adjacence);
            }

            void forEachAdjacent(Consumer<Adjacence<V, W>> consumer) {
                for(Adjacence<V, W> candidate :adjacences) {
                    consumer.accept(candidate);
                }
            }
        }

        static class Adjacence<V, W> {
            V destination;
            W weight;

            Adjacence(V destination, W weight) {
                this.destination = destination;
                this.weight = weight;
            }
        }

        private final Supplier<W> zero;
        private final DijkstaAccumulator<W> sum;

        Dijkstra(Supplier<W> zero, DijkstaAccumulator<W> sum) {
            this.zero = zero;
            this.sum = sum;
        }

        public W minimumPath(Iterator<UndirectedEdge<V, W>> edges, V source, V target, Iterator<V> allVertices) {
            DijkstaCompare<W> comparator = new FirstIsShorter<W>();
            Iterator<UndirectedEdge<V, W>> filteredEdges = new RemoveMultipleEdges<V,W>(comparator).filter(new RemoveLoops<V, W>().filter(edges));
            VerticesRepository<V, W> repository = new VerticesRepository<>(filteredEdges);

            // init structures (predecessors and distances)
            Map<V, DijkstraStructure<V,W>> structures = new HashMap();

            allVertices.forEachRemaining((v) -> {
                DijkstraStructure structure = new DijkstraStructure();
                structures.put(v, structure);
                repository.getOrCreate(v);
            });

/*
            repository.forEachVertex((v) -> {
                DijkstraStructure structure = new DijkstraStructure();
                structures.put(v.id, structure);
            });
*/


            // init source
            structures.get(source).cumulatedDistance = zero.get();
            DijkstraCalculationSteps<V, W> calculations = new DijkstraCalculationSteps(structures);

            while(calculations.canDoNextStep()) {
                Vertex<V,W> u = repository.get(calculations.getMinimal(comparator));
                u.forEachAdjacent((adjacence) -> {
                    DijkstraStructure<V,W> neighbour = structures.get(adjacence.destination);
                    DijkstraStructure<V,W> me = structures.get(u.id);
                    W candidatedDistance = sum.sum(me.cumulatedDistance, adjacence.weight);

                    try {
                        if (comparator.firstIsShorter(candidatedDistance, neighbour.cumulatedDistance)) {
                            neighbour.cumulatedDistance = candidatedDistance;
                            neighbour.predecessor = u;
                            calculations.put(adjacence.destination, candidatedDistance);
                        }
                    } catch(Exception e) {
                        throw new RuntimeException(e);
                    }

                });
            }

            return structures.get(target).cumulatedDistance;
        }

        static class DijkstraCalculationSteps<V,W> {

            private final Map<V, W> distances = new HashMap<>();

            DijkstraCalculationSteps(Map<V, DijkstraStructure<V,W>> structures) {
                for(V v : structures.keySet()) {
                    distances.put(v, structures.get(v).cumulatedDistance);
                }
            }

            void put(V vertex, W distance) {
                distances.put(vertex, distance);
            }

            V getMinimal(DijkstaCompare<W> comparator) {
                V minimal = null;
                W shortest = null;
                for(V v : distances.keySet()) {
                    if(minimal==null) {
                        minimal = v;
                        shortest = distances.get(v);
                    }
                    if(comparator.firstIsShorter(distances.get(v), shortest)) {
                        minimal = v;
                        shortest = distances.get(v);
                    }
                }

                distances.remove(minimal);

                return minimal;
            }

            boolean canDoNextStep() {
                return !distances.isEmpty();
            }
        }

        static class DijkstraStructure<V, W> {
            Vertex<V,W> predecessor = null;
            W cumulatedDistance = null;
        }


    }


    @FunctionalInterface
    interface DijkstaZero<W> {
        W get();
    }

    @FunctionalInterface
    interface DijkstaAccumulator<W> {
        W sum(W first, W second);
    }


    static class VerticesRepository<V, W> {
        final Map<V, Dijkstra.Vertex<V, W>> vertices = new HashMap<>();

        VerticesRepository(Iterator<Dijkstra.UndirectedEdge<V, W>> edges) {
            while(edges.hasNext()) {
                Dijkstra.UndirectedEdge<V, W> edge = edges.next();
                Dijkstra.Vertex<V, W> from = getOrCreate(edge.from);
                Dijkstra.Vertex<V, W> to = getOrCreate(edge.to);
                from.addAdjacence(new Dijkstra.Adjacence<>(to.id, edge.weight));
                to.addAdjacence(new Dijkstra.Adjacence<>(from.id, edge.weight));
            }
        }

        Dijkstra.Vertex<V, W> getOrCreate(V target) {
            Dijkstra.Vertex result = vertices.get(target);
            if(result==null) {
                result = new Dijkstra.Vertex<>(target);
                vertices.put(target, result);
            }
            return result;
        }

        Dijkstra.Vertex<V, W> get(V target) {
            return vertices.get(target);
        }

        public void forEachVertex(Consumer<Dijkstra.Vertex<V,W>> consumer) {
            vertices.values().forEach((candidate) -> {
                consumer.accept(candidate);
            });
        }
    }

    @FunctionalInterface
    interface DijkstaCompare<W> {
        boolean firstIsShorter(W first, W second);
    }

    @FunctionalInterface
    interface DijkstraFilter<V, W> {
        Iterator<Dijkstra.UndirectedEdge<V, W>> filter(Iterator<Dijkstra.UndirectedEdge<V, W>> edges);
    }

    static class FirstIsShorter<W> implements DijkstaCompare<W> {
        public boolean firstIsShorter(W first, W second) {

            if(first==null) {
                return false;
            }
            if(second==null) {
                return true;
            }

            if(first instanceof Integer && second instanceof Integer) {
                int a = (Integer)first;
                int b = (Integer)second;
                return a<b;
            } else {
                throw new IllegalArgumentException("Parameters should be numbers");
            }
        }
    }

    static class RemoveLoops<V, W> implements DijkstraFilter<V, W> {
        @Override
        public Iterator<Dijkstra.UndirectedEdge<V, W>> filter(Iterator<Dijkstra.UndirectedEdge<V, W>> edges) {
            List<Dijkstra.UndirectedEdge<V, W>> result = new ArrayList<>();
            while(edges.hasNext()) {
                Dijkstra.UndirectedEdge<V, W> candidate = edges.next();
                if(candidate.from.equals(candidate.to)) {
                    // this is loop
                } else {
                    result.add(candidate);
                }
            }
            return result.iterator();
        }
    }

    static class RemoveMultipleEdges<V, W> implements DijkstraFilter<V, W> {

        private final DijkstaCompare<W> comparator;

        RemoveMultipleEdges(DijkstaCompare<W> comparator) {
            this.comparator = comparator;
        }

        @Override
        public Iterator<Dijkstra.UndirectedEdge<V, W>> filter(Iterator<Dijkstra.UndirectedEdge<V, W>> edges) {
            Map<SamePair<V>, W> merging = new HashMap<>();
            while(edges.hasNext()) {
                Dijkstra.UndirectedEdge<V, W> candidate = edges.next();
                SamePair<V> pair = new SamePair<V>();
                pair.first = candidate.from;
                pair.second = candidate.to;

                // comparing
                W previousWeight = merging.get(pair);
                if(previousWeight==null) {
                    merging.put(pair, candidate.weight);
                } else if (comparator.firstIsShorter(candidate.weight, previousWeight)) {
                        merging.put(pair, candidate.weight);
                }
            }
            List<Dijkstra.UndirectedEdge<V, W>> result = new ArrayList<>();
            for(SamePair<V> pair : merging.keySet()) {
                result.add(new Dijkstra.UndirectedEdge<>(pair.first, pair.second, merging.get(pair)));
            }
            return result.iterator();
        }

        static class SamePair<V> {
            V first;
            V second;

            @Override
            public boolean equals(Object o) {
                SamePair co = (SamePair)o;
                return (
                        (co.first.equals(this.first) && co.second.equals(this.second))
                        || (co.first.equals(this.second) && co.second.equals(this.first))
                );
            }

            @Override
            public int hashCode() {
                return this.first.hashCode()+this.second.hashCode();
            }
        }
    }
}
