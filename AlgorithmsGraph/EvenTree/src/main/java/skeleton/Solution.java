package skeleton;

import static java.lang.System.out;

import java.util.*;

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
                    int vertexFrom = in.nextInt();
                    int vertexTo = in.nextInt();

                    solution.addEdge(vertexFrom, vertexTo);
                }
                int edgesToRemove = solution.maximumNumberOfEdgesToRemoveToHaveForestWithEvenNumberOfVertices();
                out.print(edgesToRemove);

        }
    }

    int vertices;

    protected Solution(int nodes) {
        this.vertices = nodes;
    }

    private Map<Integer, Vertex> collection = new HashMap<>();

    private Vertex getOrCreate(int node) {
        Vertex result = collection.get(node);
        if(result==null) {
            result = new VertexImpl(node);
            collection.put(node, result);
        }
        return result;
    }

    public void addEdge(int vertexFirst, int vertexSecond) {
        Vertex first = getOrCreate(vertexFirst);
        Vertex second = getOrCreate(vertexSecond);
        first.edgeWith(second);
        second.edgeWith(first);
    }

    public int maximumNumberOfEdgesToRemoveToHaveForestWithEvenNumberOfVertices() {
        Iterator<Solution.Vertex> postorder = traverse();
        Solution.WeightsComputations weights = new Solution.WeightsComputations(postorder);
        return weights.countEvenWeights()-1;
    }


    public Vertex getParent() {
        return getOrCreate(1);
    }

    public Iterator<Vertex> traverse() {
        final List<Vertex> sequence = new ArrayList<>();

        Vertex parent = getOrCreate(1);

        parent.visit(new TraversingListener() {
            @Override
            public void onProcess(int id) {
                sequence.add(getOrCreate(id));
            }
        }, parent.getId());

        return sequence.iterator();
    }

    interface TraversingListener {
        void onProcess(int id);
    }

    interface Vertex {
        int countNeighbours();

        void edgeWith(Vertex neighbour);

        Integer getId();

        void visit(TraversingListener listener, int exceptMe);

        void setParent(Vertex candidate);   // TODO: separate it

        Vertex getParent(); // TODO: separate it

        Iterator<Vertex> neighboursExceptParent();
    }

    static class VertexImpl implements Vertex {

        private final int id;
        private List<Vertex> neighbours = new ArrayList<>();
        private Vertex parent;

        public void setParent(Vertex candidate) {
            this.parent = candidate;
        }

        public Vertex getParent() {
            return this.parent;
        }

        public VertexImpl(int id) {
            this.id = id;
        }

        public Integer getId() {
            return this.id;
        }

        public void edgeWith(Vertex neighbour) {
            neighbours.add(neighbour);
        }

        public Iterator<Vertex> neighboursExceptParent() {
            List<Vertex> result = new ArrayList<>();
            for(Vertex neighbour : neighbours) {
                if(getParent()!=null) {
                    if(neighbour.getId()!=getParent().getId()) {
                        result.add(neighbour);
                    }
                } else {
                    result.add(neighbour);
                }
            }
            return result.iterator();
        }

        public int countNeighbours() {
            return neighbours.size();
        }

        public void visit(TraversingListener listener, int exceptMe) {
            for(Vertex neighbour : neighbours) {
                if(neighbour.getId()!=exceptMe) {
                    // [begin] TODO: separate it
                 //   out.println("Parent of "+neighbour.getId()+" is "+getId());
                    neighbour.setParent(this);
                    // [end] TODO: separate it
                    neighbour.visit(listener, getId());
                }
            }
            listener.onProcess(getId());
        }
    }


    // =========================


    static class WeightsComputations {

        private Map<Integer, Integer> weights = new HashMap<>();

        public int countEvenWeights() {
            int count = 0;
            for(Integer w : weights.values()) {
                if(w%2==0) {
                    count++;
                }
            }
            return count;
        }

        public WeightsComputations(Iterator<Solution.Vertex> postorder) {
            while(postorder.hasNext()) {
                Vertex candidate = postorder.next();
                int weight = readWeightFor(candidate);
                weights.put(candidate.getId(), weight);
            }
        }

        private int readWeightFor(Vertex vertex) {
          //  out.println("Considering WEIGHT for vertex "+vertex.getId());

            int sumChildrenWeight = 0;
            Iterator<Vertex> children = vertex.neighboursExceptParent();
            while(children.hasNext()) {
                Vertex child = children.next();
                sumChildrenWeight += weights.get(child.getId());
            }
            //out.println("\t\tChildrens weight is "+sumChildrenWeight+" plus 1 for me");

            return sumChildrenWeight+1;
        }

        public int getWeightForNode(int node) {
            return weights.get(node);
        }
    }
}
