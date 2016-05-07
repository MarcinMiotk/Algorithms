package com.snmill.cp;

import com.snmill.cp.Solution.MatrixIterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 */
public class DividedSolutionTest {

    @Test
    public void rotate_one() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6}
        };

        int[][] rotated = Solution.rotate(matrix, 1);
    }

    @Test
    public void maxRings_2() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6}
        };
        assertEquals(2, Solution.maxRings(matrix.length, matrix[0].length));
    }

    @Test
    public void maxRings_1() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {7, 8, 9, 1}
        };
        assertEquals(1, Solution.maxRings(matrix.length, matrix[0].length));
    }

    @Test
    public void maxRings_3() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6}
        };
        assertEquals(3, Solution.maxRings(matrix.length, matrix[0].length));
    }

    @Test
    public void maxRings_4() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6, 1, 2},
            {7, 8, 9, 1, 2, 3, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2},
            {1, 2, 3, 4, 5, 6, 1, 2},
            {1, 2, 3, 4, 5, 6, 1, 2},
            {1, 2, 3, 4, 5, 6, 1, 2},
            {1, 2, 3, 4, 5, 6, 1, 2},
            {1, 2, 3, 4, 5, 6, 1, 2}
        };
        assertEquals(4, Solution.maxRings(matrix.length, matrix[0].length));
    }

    @Test
    public void MatrixIterator_ring_0() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6}
        };

        MatrixIterator iterator = new MatrixIterator(matrix, 6, 4, 0);
        assertEquals(new Solution.Coordinates(0, 0), iterator.next());
        assertEquals(new Solution.Coordinates(1, 0), iterator.next());
        assertEquals(new Solution.Coordinates(2, 0), iterator.next());
        assertEquals(new Solution.Coordinates(3, 0), iterator.next());

        assertEquals(new Solution.Coordinates(3, 1), iterator.next());
        assertEquals(new Solution.Coordinates(3, 2), iterator.next());
        assertEquals(new Solution.Coordinates(3, 3), iterator.next());
        assertEquals(new Solution.Coordinates(3, 4), iterator.next());
        assertEquals(new Solution.Coordinates(3, 5), iterator.next());

        assertEquals(new Solution.Coordinates(2, 5), iterator.next());
        assertEquals(new Solution.Coordinates(1, 5), iterator.next());
        assertEquals(new Solution.Coordinates(0, 5), iterator.next());

        assertEquals(new Solution.Coordinates(0, 4), iterator.next());
        assertEquals(new Solution.Coordinates(0, 3), iterator.next());
        assertEquals(new Solution.Coordinates(0, 2), iterator.next());
        assertEquals(new Solution.Coordinates(0, 1), iterator.next());

        assertFalse("Should be the end of ring 0", iterator.hasNext());
    }

    @Test
    public void MatrixIterator_ring_1() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6}
        };

        MatrixIterator iterator = new MatrixIterator(matrix, 6, 4, 1);

        assertEquals(new Solution.Coordinates(1, 1), iterator.next());
        assertEquals(new Solution.Coordinates(2, 1), iterator.next());

        assertEquals(new Solution.Coordinates(2, 2), iterator.next());
        assertEquals(new Solution.Coordinates(2, 3), iterator.next());
        assertEquals(new Solution.Coordinates(2, 4), iterator.next());

        assertEquals(new Solution.Coordinates(1, 4), iterator.next());

        assertEquals(new Solution.Coordinates(1, 3), iterator.next());
        assertEquals(new Solution.Coordinates(1, 2), iterator.next());

        assertFalse("Should be the end of ring 1", iterator.hasNext());
    }

    @Test
    public void MatrixIterator_ring_2() {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6}
        };

        MatrixIterator iterator = new MatrixIterator(matrix, 6, 6, 2);
        assertEquals(new Solution.Coordinates(2, 2), iterator.next());
        assertEquals(new Solution.Coordinates(3, 2), iterator.next());
        assertEquals(new Solution.Coordinates(3, 3), iterator.next());
        assertEquals(new Solution.Coordinates(2, 3), iterator.next());

        assertFalse("Should be the end of ring 3", iterator.hasNext());
    }
}
