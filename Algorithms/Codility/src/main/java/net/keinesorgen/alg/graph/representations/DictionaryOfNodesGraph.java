package net.keinesorgen.alg.graph.representations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Nastepniki (wezly odchodzace).
 *
 * Poprzedniki (wezly dochodzace).
 */
public class DictionaryOfNodesGraph<T> {

    private final Map<T, LinkedList<T>> nodes = new HashMap<T, LinkedList<T>>();

    static class TooManyNodesInGraphException extends Exception {

    }

    public void join(T source, T... destination) throws TooManyNodesInGraphException {
        LinkedList<T> joined = nodes.get(source);
        if (joined == null) {
            joined = new LinkedList<>();
            nodes.put(source, joined);
        }
        joined.addAll(Arrays.asList(destination));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T key : nodes.keySet()) {
            sb.append(key);
            sb.append(" -> ");

            for (T directedTo : nodes.get(key)) {
                sb.append(directedTo);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
