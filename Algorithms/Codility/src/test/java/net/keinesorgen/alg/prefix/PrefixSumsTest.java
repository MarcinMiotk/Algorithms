package net.keinesorgen.alg.prefix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class PrefixSumsTest {

    public PrefixSumsTest() {
    }

    /**
     * Test of prefixSums method, of class PrefixSums.
     */
    @Test
    public void testPrefixSums() {
        int[] A = {5, 3, 2, 5, 1, 1};
        PrefixSums instance = new PrefixSums();
        int[] expResult = {0, 5, 8, 10, 15, 16, 17};
        int[] result = instance.prefixSums(A);
        assertArrayEquals(expResult, result);
    }

}
