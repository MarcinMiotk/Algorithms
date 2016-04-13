package net.keinesorgen.alg.graph.representations;

/**
 * Representation of graph with two dimensional array.
 * 
 * Another name: The matrix of neighbourhood.
 *
 * Rows = Beginning nodes (source). Cols = Ending nodes (destination).
 *
 * Disadvantages:
 *
 * - you have to know how many nodes has the graph.
 *
 * - redundancy of memory (a lot of cells are false). O(V^2) - memory complexity
 */
public class TwoDimensionalArrayGraph<T> {

    private final boolean[][] EDGES;
    private T[] labels;

    public TwoDimensionalArrayGraph(int nodes) {
        this.EDGES = new boolean[nodes][nodes];
        this.labels = (T[]) new Object[nodes];
    }

    private final static int NIL = -1;

    static class TooManyNodesInGraphException extends Exception {

    }

    private int index(T of, boolean insertIfNew) throws TooManyNodesInGraphException {
        int firstEmpty = NIL;
        for (int i = 0; i < labels.length; i++) {
            // if this position is empty then we remember it for
            // future add in case this candidate is new
            if (labels[i] == null && firstEmpty == NIL) {
                firstEmpty = i;
            } else if (of.equals(labels[i])) {
                // we have found this item
                return i;
            }
        }
        if (insertIfNew) {
            if (firstEmpty == NIL) {
                // graph size is exceeded
                throw new TooManyNodesInGraphException();
            } else {
                // if not found, then we allocate first free position
                labels[firstEmpty] = of;
                return firstEmpty;
            }
        } else {
            return NIL;
        }
    }

    public void join(T source, T... destination) throws TooManyNodesInGraphException {
        int sourceIdx = index(source, true);
        for (int i = 0; i < destination.length; i++) {
            int destinationIdx = index(destination[i], true);
            EDGES[sourceIdx][destinationIdx] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < EDGES.length; row++) {
            for (int col = 0; col < EDGES[row].length; col++) {
                sb.append(EDGES[row][col] ? "1" : "0");
            }
            sb.append("\n");
        }
        sb.append("\n");
        for (int i = 0; i < labels.length; i++) {
            sb.append(labels[i] != null ? labels[i] : "");
        }
        return sb.toString();
    }

}
