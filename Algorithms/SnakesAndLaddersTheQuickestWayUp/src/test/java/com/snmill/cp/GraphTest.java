package com.snmill.cp;

import com.snmill.cp.Graph.Vertex;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class GraphTest {

    public GraphTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        create100vertexes();
        link100VertexesWithDices();
    }

    @After
    public void tearDown() {
        graph = null;
    }

    private void create100vertexes() {
        for (int v = 1; v <= 100; v++) {
            graph.createVertex(v);
        }
    }

    private void link100VertexesWithDices() {
        // there are 6 dices at the roll (1,2,3,4,5,6)
        for (int v = 1; v <= 100; v++) {
            for (int dice = 1; dice <= 6; dice++) {
                int toVertex = v + dice;
                if (toVertex <= 100) {
                    graph.edge(v, toVertex, dice);
                } else {
                    graph.edge(v, v, dice);
                }
            }
        }
    }

    @Test
    public void thereAre_100_vertexes() {
        int vertexes = graph.countVertexes();
        assertEquals(100, vertexes);
    }

    @Test
    public void getSquareReachedFromByDice_4_3_shouldReturn_7() {
        int reached = graph.getSquareReachedFromByDice(4, 3);
        assertEquals(7, reached);
    }

    @Test
    public void getSquareReachedFromByDice_10_6_shouldReturn_16() {
        int reached = graph.getSquareReachedFromByDice(10, 6);
        assertEquals(16, reached);
    }

    @Test
    public void getSquareReachedFromByDice_99_2_shouldReturn_99() {
        int reached = graph.getSquareReachedFromByDice(99, 2);
        assertEquals(99, reached);
    }

    @Test
    public void getSquareReachedFromByDice_99_1_shouldReturn_100() {
        int reached = graph.getSquareReachedFromByDice(99, 1);
        assertEquals(100, reached);
    }

    @Test
    public void vertexHas_6_Edges() {
        Vertex v10 = graph.getVertex(10);
        Vertex dice_1 = v10.getEdge(1);
        Vertex dice_2 = v10.getEdge(2);
        Vertex dice_3 = v10.getEdge(3);
        Vertex dice_4 = v10.getEdge(4);
        Vertex dice_5 = v10.getEdge(5);
        Vertex dice_6 = v10.getEdge(6);

        assertEquals(11, dice_1.id);
        assertEquals(12, dice_2.id);
        assertEquals(13, dice_3.id);
        assertEquals(14, dice_4.id);
        assertEquals(15, dice_5.id);
        assertEquals(16, dice_6.id);
    }

    @Test
    public void afterAddLadder_dicesAffectsTheSkipToTargetSquare() {
        graph.addLadderOrSnake(10, 20);
        Vertex v9 = graph.getVertex(9);     // 9+1=10 and the ladder brings it to 20
        Vertex shouldBe20 = v9.getEdge(1);
        assertEquals(20, shouldBe20.id);
    }

    @Test
    public void afterAddLadder_floorLostsItsEdges() {
        graph.addLadderOrSnake(10, 20);
        Vertex v10 = graph.getVertex(10);
        int edges = v10.edges.size();
        assertEquals(0, edges);
    }
    
    @Test
    public void afterAddLadder_ceilingHas6Edges() {
        graph.addLadderOrSnake(10, 20);
        Vertex v20 = graph.getVertex(20);
        int edges = v20.edges.size();
        assertEquals(6, edges);
    }    

    @Test
    public void afterAddSnake_dicesAffectsTheSkipToTargetSquare() {
        graph.addLadderOrSnake(20, 10);
        Vertex v19 = graph.getVertex(19);     // 19+1=20 and the snake brings it to 10
        Vertex shouldBe10 = v19.getEdge(1);
        assertEquals(10, shouldBe10.id);
    }

    @Test
    public void printAll() {
        graph.addLadderOrSnake(10, 20);
        graph.addLadderOrSnake(21, 30);
        graph.addLadderOrSnake(31, 40);
        graph.addLadderOrSnake(41, 50);
        graph.addLadderOrSnake(51, 60);
        graph.addLadderOrSnake(61, 70);
        graph.addLadderOrSnake(71, 80);
        graph.addLadderOrSnake(81, 90);
        graph.addLadderOrSnake(91, 98);
        for (int v = 1; v <= 100; v++) {
            Vertex vertex = graph.getVertex(v);
            for (int dice = 0; dice < vertex.edges.size(); dice++) {
                System.out.println("From " + vertex.id + " with dice " + (dice + 1) + " to " + vertex.edges.get(dice).id);
            }
        }
    }
}
