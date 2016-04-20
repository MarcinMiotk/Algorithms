package com.snmill.cp;

import com.snmill.cp.Graph.Vertex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BreadthFirstSearch {

    static class Visit {

        Visit parent = null;
        int distance = -1;
        Vertex vertex;

        public Visit(Vertex vertex) {
            this.vertex = vertex;
        }
    }

    public Visit BreadthFirstSearch(Graph graph, int targetId) {
        List<Visit> visits = new ArrayList<>(graph.countVertexes());
        Map<Integer, Visit> map = new HashMap<>();
        Iterator<Vertex> graphVertexes = graph.all();
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
            Iterator<Vertex> edges = current.vertex.edges.iterator();
            while (edges.hasNext()) {
                Vertex edge = edges.next();
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
