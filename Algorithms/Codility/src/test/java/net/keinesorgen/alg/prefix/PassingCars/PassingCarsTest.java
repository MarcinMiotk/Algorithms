package net.keinesorgen.alg.prefix.PassingCars;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PassingCarsTest {

    public PassingCarsTest() {
    }

    @Test
    public void testSolution_ok_5() {
        int[] A = {0, 1, 0, 1, 1};
        PassingCars instance = new PassingCars();
        int expResult = 5;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

    @Test
    public void testSolution_ok_14() {
        int[] A = {0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        PassingCars instance = new PassingCars();
        int expResult = 14;
        int result = instance.solution(A);
        assertEquals(expResult, result);
    }

}
