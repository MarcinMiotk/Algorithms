package net.keinesorgen.alg.counting;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class CountingElementsTest {

    public CountingElementsTest() {
    }

    /**
     * Test of counting method, of class CountingElements.
     */
    @Test
    public void testCounting() {
        int[] from = {1, 1, 2, 2, 2, 2, 3, 4, 7};
        int[] expResult = {0, 2, 4, 1, 1, 0, 0, 1};
        int[] result = CountingElements.counting(from);
        assertArrayEquals(expResult, result);
    }

}
