package net.keinesorgen.alg.fibonacci;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class FiboWithGoldenRatioTest {

    public FiboWithGoldenRatioTest() {
    }

    FiboWithGoldenRatio instance = new FiboWithGoldenRatio();

    @Test
    public void testFind() {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34

        assertEquals(2, instance.find(3));
        assertEquals(3, instance.find(4));
        assertEquals(5, instance.find(5));
        assertEquals(8, instance.find(6));
        assertEquals(13, instance.find(7));
        assertEquals(21, instance.find(8));
    }

}
