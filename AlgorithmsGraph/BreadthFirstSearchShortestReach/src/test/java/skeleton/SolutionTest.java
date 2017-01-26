package skeleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void test_first() {
        String input = "2\n"
                + "4 2\n"
                + "1 2\n"
                + "1 3\n"
                + "1\n"
                + "3 1\n"
                + "2 3\n"
                + "2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("6 6 -1\r\n"
                + "-1 6", outContent.toString().trim());
    }

    @Test
    public void simpleGraph_3nodes_has_size_nodes_minus_1() {
        Solution solution = new Solution(3, 1);
        solution.addEdge(2, 3);
        List<Integer> distances = solution.solveShortestDistancesToEachOtherNodes(2);
        assertEquals(3 - 1, distances.size());
    }

    @Test
    public void bfs_lists_visited_nodes_with_size_2() {
        Solution solution = new Solution(3, 1);
        solution.addEdge(2, 3);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 2;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
        });
        assertEquals(2, sequence.size());
    }

    @Test
    public void bfs_lists_visited_nodes_with_size_3() {
        Solution solution = new Solution(4, 2);
        solution.addEdge(1, 2);
        solution.addEdge(1, 3);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 1;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
        });
        assertEquals(3, sequence.size());
    }

    @Test
    public void bfs_lists_visited_nodes_with_size_1() {
        Solution solution = new Solution(4, 2);
        solution.addEdge(1, 2);
        solution.addEdge(1, 3);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 4;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
        });
        assertEquals(1, sequence.size());
    }

    @Test
    public void bfs_lists_visited_nodes_from_node_1_in_sequence_1_3_2() {
        Solution solution = new Solution(4, 2);
        solution.addEdge(1, 2);
        solution.addEdge(1, 3);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 1;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
        });
        assertEquals("1", sequence.get(0));
        assertEquals("2", sequence.get(1));
        assertEquals("3", sequence.get(2));
    }

    @Test
    public void bfs_lists_visited_nodes_from_node_4_in_sequence_4() {
        Solution solution = new Solution(4, 2);
        solution.addEdge(1, 2);
        solution.addEdge(1, 3);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 4;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
        });
        assertEquals("4", sequence.get(0));
    }
}
