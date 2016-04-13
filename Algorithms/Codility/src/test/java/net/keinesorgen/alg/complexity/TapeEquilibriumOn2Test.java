package net.keinesorgen.alg.complexity;

import net.keinesorgen.alg.complexity.TapeEquilibriumOn2.Parts;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class TapeEquilibriumOn2Test {

    public TapeEquilibriumOn2Test() {
    }

    /**
     * P = 1, difference = |3 − 10| = 7 P = 2, difference = |4 − 9| = 5 P = 3,
     * difference = |6 − 7| = 1 P = 4, difference = |10 − 3| = 7
     */
    @Test
    public void test_difference_1() {
        int[] A = new int[]{3, 1, 2, 4, 3};
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        assertEquals(7, instance.divide(A, 1).difference());
        assertEquals(5, instance.divide(A, 2).difference());
        assertEquals(1, instance.divide(A, 3).difference());
        assertEquals(7, instance.divide(A, 4).difference());

    }

    @Test
    public void test_solution_2_two_elements() {
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        assertEquals(2000, instance.solution(new int[]{-1000, 1000}));
    }

    @Test
    public void test_solution_1() {
        int[] A = new int[]{3, 1, 2, 4, 3};
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        assertEquals(1, instance.solution(A));
    }

    @Test
    public void test_solution_2_two_elements_b() {
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        assertEquals(2000, instance.solution(new int[]{2000, 0}));
        assertEquals(2000, instance.solution(new int[]{0, 2000}));
    }

    @Test
    public void test_divide_1() {
        int[] A = new int[]{101, 102, 103, 104, 105, 106, 107, 108};
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        Parts result = instance.divide(A, 3);

        assertArrayEquals(new int[]{101, 102, 103}, result.partFirst);
        assertArrayEquals(new int[]{104, 105, 106, 107, 108}, result.partSecond);
    }

    @Test
    public void test_sum_1() {
        int[] A = new int[]{1, 2, 3};
        TapeEquilibriumOn2 instance = new TapeEquilibriumOn2();
        int result = instance.sum(A);

        assertEquals(6, result);
    }

}
