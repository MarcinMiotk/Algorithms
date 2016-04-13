package net.keinesorgen.alg.complexity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class TapeEquilibriumOnTest {

    public TapeEquilibriumOnTest() {
    }

    @Test
    public void test_solution_2_two_elements() {
        TapeEquilibriumOn instance = new TapeEquilibriumOn();
        assertEquals(2000, instance.solution(new int[]{-1000, 1000}));
    }

    @Test
    public void test_solution_1() {
        int[] A = new int[]{3, 1, 2, 4, 3};
        TapeEquilibriumOn instance = new TapeEquilibriumOn();
        assertEquals(1, instance.solution(A));
    }

    @Test
    public void test_solution_2_two_elements_b() {
        TapeEquilibriumOn instance = new TapeEquilibriumOn();
        assertEquals(2000, instance.solution(new int[]{2000, 0}));
        assertEquals(2000, instance.solution(new int[]{0, 2000}));
    }

}
