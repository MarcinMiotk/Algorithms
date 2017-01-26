package skeleton;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class SolutionSecondTest {

    @Test
    public void bfs_lists_visited_nodes_from_node_6_in_sequence_1_2_3_4_6_5() {
        Solution solution = new Solution(6, 6);
        solution.addEdge(1, 2);
        solution.addEdge(1, 3);
        solution.addEdge(3, 4);
        solution.addEdge(3, 6);
        solution.addEdge(4, 5);
        solution.addEdge(5, 6);

        List<String> sequence = new ArrayList<>();
        Integer fromNode = 1;
        solution.bfsVisiting(fromNode, (String node, String parent) -> {
            sequence.add(node);
            out.println(node + " has parent " + parent);

        });
        assertEquals("1", sequence.get(0));
        assertEquals("2", sequence.get(1));
        assertEquals("3", sequence.get(2));
        assertEquals("4", sequence.get(3));
        assertEquals("6", sequence.get(4));
        assertEquals("5", sequence.get(5));
    }

    @Test
    public void distances() {
        /*
            1 has parent null
            2 has parent 1
            3 has parent 1
            4 has parent 3
            6 has parent 3
            5 has parent 4
         */

        Solution.BfsDistances distances = new Solution.BfsDistances();
        distances.visit("1", null);
        distances.visit("2", "1");
        distances.visit("3", "1");
        distances.visit("4", "3");
        distances.visit("6", "3");
        distances.visit("5", "4");

        assertEquals(0, distances.distanceFrom("1"));
        assertEquals(1, distances.distanceFrom("2"));
        assertEquals(1, distances.distanceFrom("3"));
        assertEquals(2, distances.distanceFrom("4"));
        assertEquals(3, distances.distanceFrom("5"));
        assertEquals(2, distances.distanceFrom("6"));
    }
}
