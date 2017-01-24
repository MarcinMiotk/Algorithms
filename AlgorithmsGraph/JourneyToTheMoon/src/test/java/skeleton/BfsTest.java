package skeleton;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class BfsTest {

    Solution solution;

    @Before
    public void up() {
        solution = new Solution();
    }

    @Test
    public void threeChildrens() {
        solution.addPairFromTheSameCountry(0, 1);
        solution.addPairFromTheSameCountry(0, 2);
        solution.addPairFromTheSameCountry(0, 3);
        List<String> visited = solution.getVisitedVertexes();
        assertEquals("0", visited.get(0));
        assertEquals("1", visited.get(1));
        assertEquals("2", visited.get(2));
        assertEquals("3", visited.get(3));
    }

    @Test
    public void threeChildrensInAnotherSequence() {
        solution.addPairFromTheSameCountry(0, 3);
        solution.addPairFromTheSameCountry(0, 2);
        solution.addPairFromTheSameCountry(0, 1);
        List<String> visited = solution.getVisitedVertexes();
        assertEquals("0", visited.get(0));
        assertEquals("3", visited.get(1));
        assertEquals("2", visited.get(2));
        assertEquals("1", visited.get(3));
    }

    @Test
    public void eightChildrensInAnotherSequence() {
        solution.addPairFromTheSameCountry(1, 2);
        solution.addPairFromTheSameCountry(1, 3);
        solution.addPairFromTheSameCountry(1, 4);

        solution.addPairFromTheSameCountry(2, 5);
        solution.addPairFromTheSameCountry(2, 6);

        solution.addPairFromTheSameCountry(4, 7);
        solution.addPairFromTheSameCountry(4, 8);

        List<String> visited = solution.getVisitedVertexes();
        assertEquals("1", visited.get(0));
        assertEquals("2", visited.get(1));
        assertEquals("3", visited.get(2));
        assertEquals("4", visited.get(3));
//        assertEquals("5", visited.get(4));
//        assertEquals("6", visited.get(5));
//        assertEquals("7", visited.get(6));
//        assertEquals("8", visited.get(7));
    }

    @Test
    public void twoSeparatedGraphs() {
        solution.addPairFromTheSameCountry(0, 1);
        solution.addPairFromTheSameCountry(0, 2);
        solution.addPairFromTheSameCountry(0, 3);
        solution.addPairFromTheSameCountry(4, 5);
        solution.addPairFromTheSameCountry(4, 6);
        solution.addPairFromTheSameCountry(6, 7);
        List<String> visited = solution.getVisitedVertexes();
    }

}
