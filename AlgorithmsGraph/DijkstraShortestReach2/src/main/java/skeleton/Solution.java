package skeleton;


import javafx.scene.layout.Priority;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.out;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int testcases = in.nextInt();
            for(int testcase=0; testcase<testcases; testcase++) {
                int vertices = in.nextInt();
                int edges = in.nextInt();

                Collection<Dijkstra.UndirectedEdge<Integer, Long>> allEdges = new ArrayList<>();

                for (int edge = 0; edge < edges; edge++) {
                    int vertexFirst = in.nextInt();
                    int vertexSecond = in.nextInt();
                    int cost = in.nextInt();

                    allEdges.add(new Dijkstra.UndirectedEdge<>(vertexFirst, vertexSecond, (long)cost));
                }

                int source = in.nextInt();

                List<Integer> all = new ArrayList<>();
                for(int v=1; v<=vertices; v++) {
                    all.add(v);
                }



                Iterator allVertices = all.iterator();
                Map<Integer, Long> distances = new Dijkstra<Integer, Long>(Solution::zero, Solution::infinity, Solution::add).minimumPath(allEdges.iterator(), source, allVertices);


                boolean first = true;
                for(int target=1; target<=vertices; target++) {
                    if(target!=source) {
                        if(first) {
                            first = false;
                        } else {
                            out.print(" ");
                        }

                        if(distances.get(target)==null || distances.get(target).equals(new Long(Integer.MAX_VALUE))) {
                            out.print("-1");
                        } else {
                            out.print(distances.get(target));
                        }
                    }
                }
                out.println();
            }
        }
    }

    static Long zero() {
        return (long)0;
    }

    static Long infinity() {
        return (long)Integer.MAX_VALUE;
    }

    static Long add(Long first, Long second) {
        if(first==null || second==null) {
            return null;
        } else {
            return first+second;
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
        private final Supplier<W> infinity;
        private final DijkstaAccumulator<W> sum;

        Dijkstra(Supplier<W> zero, Supplier<W> infinity, DijkstaAccumulator<W> sum) {
            this.zero = zero;
            this.infinity = infinity;
            this.sum = sum;
        }

        public Map<V, W> minimumPath(Iterator<UndirectedEdge<V, W>> edges, V source, Iterator<V> allVertices) {
            DijkstaCompare<W> comparator = new FirstIsShorter<>();


            long startMetric = System.currentTimeMillis();


            Iterator<UndirectedEdge<V, W>> filteredEdges = new RemoveMultipleEdges<V,W>(comparator).filter(new RemoveLoops<V, W>().filter(edges));
            VerticesRepository<V, W> repository = new VerticesRepository<>(filteredEdges);

            long processing1 = System.currentTimeMillis()-startMetric;

            // init structures (predecessors and distances)
            Map<V, DijkstraStructure<V,W>> structures = new HashMap();

            allVertices.forEachRemaining((v) -> {
                DijkstraStructure structure = new DijkstraStructure();
                structure.cumulatedDistance = infinity.get();
                structures.put(v, structure);
                repository.getOrCreate(v);
            });

/*
            repository.forEachVertex((v) -> {
                DijkstraStructure structure = new DijkstraStructure();
                structures.put(v.id, structure);
            });
*/

            long processing2 = System.currentTimeMillis()-startMetric;

            // init source
            structures.get(source).cumulatedDistance = zero.get();
            DijkstraCalculationSteps<V, W> calculations = new DijkstraCalculationSteps(structures);


            long processing3 = System.currentTimeMillis()-startMetric;


            while(calculations.canDoNextStep()) {
                Vertex<V,W> u = repository.get(calculations.getMinimal(comparator));

                long startSecondMetric = System.currentTimeMillis();

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

                long processingSecond = System.currentTimeMillis()-startSecondMetric;
                long processingSecond2 = System.currentTimeMillis()-startSecondMetric;
            }


            Map<V, W> distances = new HashMap<>();
            for(V key : structures.keySet()) {
                distances.put(key, structures.get(key).cumulatedDistance);
            }
            return distances;
        }

        static class DijkstraCalculationSteps<V,W> {

            static class Item<V, W> {
                V id;
                W weight;

                Item(V v, W w) {
                    this.id = v;
                    this.weight = w;
                }
            }

//            PriorityQueue<Item<V,W>> queue = new PriorityQueue<>((vwItem, t1) -> {
//                    return ((Long)vwItem.weight).compareTo((Long)t1.weight);
 //               });

            PriorityQueue<Item<V,W>> queue = new PriorityQueue<>(new Comparator<Item<V, W>>() {
                @Override
                public int compare(Item<V, W> vwItem, Item<V, W> t1) {
                    return (int)((Long)vwItem.weight-(Long)t1.weight);
                }
            });

            DijkstraCalculationSteps(Map<V, DijkstraStructure<V,W>> structures) {
                for(V v : structures.keySet()) {
                    queue.offer(new Item<>(v, structures.get(v).cumulatedDistance));
                }
            }

            void put(V vertex, W distance) {
                queue.offer(new Item<>(vertex, distance));
            }

            V getMinimal(DijkstaCompare<W> comparator) {
                Item<V,W> minimal = queue.poll();
                return minimal.id;
            }

            boolean canDoNextStep() {
                return !queue.isEmpty();
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

            if(first instanceof Long && second instanceof Long) {
                long a = (Long)first;
                long b = (Long)second;
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
