package net.keinesorgen.alg.complexity.FrogJmp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class FrogJmpTest {

    public FrogJmpTest() {
    }

    @Test
    public void testSolution() {
        int X = 10;
        int Y = 85;
        int D = 30;
        FrogJmp instance = new FrogJmp();
        int expResult = 3;
        int result = instance.solution(X, Y, D);
        assertEquals(expResult, result);
    }

}
