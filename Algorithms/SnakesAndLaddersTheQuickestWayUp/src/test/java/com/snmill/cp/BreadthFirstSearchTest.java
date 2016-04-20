package com.snmill.cp;

import com.snmill.cp.BreadthFirstSearch.Visit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class BreadthFirstSearchTest {

    public BreadthFirstSearchTest() {
    }

    @Test
    public void testBreadthFirstSearch() {
        // like in https://en.wikipedia.org/wiki/Breadth-first_search
        Graph graph = new Graph();
        graph.createVertex(1);
        graph.createVertex(2);
        graph.createVertex(3);
        graph.createVertex(4);
        graph.createVertex(5);
        graph.createVertex(6);
        graph.createVertex(7);
        graph.createVertex(8);

        // edges
        graph.edge(1, 2, 1);
        graph.edge(1, 3, 2);
        //
        graph.edge(2, 4, 1);
        graph.edge(2, 5, 2);
        //
        graph.edge(5, 8, 1);
        //
        graph.edge(3, 6, 1);
        graph.edge(3, 7, 2);

        BreadthFirstSearch instance = new BreadthFirstSearch();
        Visit target = instance.BreadthFirstSearch(graph, 8);

        System.out.println("target.distance=" + target.distance);
        System.out.println("target.vertex.id=" + target.vertex.id);
        System.out.println("target.parent.vertex.id=" + target.parent.vertex.id);
        System.out.println("target.parent.vertex.id=" + target.parent.parent.vertex.id);
        System.out.println("target.parent.vertex.id=" + target.parent.parent.parent.vertex.id);

        assertEquals(3, target.distance);
        assertEquals(8, target.vertex.id);

        assertEquals(5, target.parent.vertex.id);
        assertEquals(2, target.parent.parent.vertex.id);
        assertEquals(1, target.parent.parent.parent.vertex.id);

    }

}
