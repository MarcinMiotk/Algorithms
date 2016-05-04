package com.snmill.cp;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class SolutionSeparatedStdoutTest {

    @Test
    public void variationsWithRepetitions_8_variations_for_k3_check_all_values() {
        int k = 3;
        int[] n = new int[]{10, 100};
        int[][] variations = Solution.variationsWithRepetitions(k, n);
        assertEquals(8, variations.length);
        assertEquals(3, variations[0].length);

        for (int[] variation : variations) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < variation.length; i++) {
                sb.append(variation[i]+" ");
            }
            System.out.println(sb.toString());
        }

        if (false) {
            assertArrayEquals(new int[]{10, 10, 10}, variations[0]);
            assertArrayEquals(new int[]{10, 10, 100}, variations[1]);
            assertArrayEquals(new int[]{10, 100, 10}, variations[2]);
            assertArrayEquals(new int[]{10, 100, 100}, variations[3]);
            assertArrayEquals(new int[]{100, 10, 10}, variations[4]);
            assertArrayEquals(new int[]{100, 10, 100}, variations[5]);
            assertArrayEquals(new int[]{100, 100, 10}, variations[6]);
            assertArrayEquals(new int[]{100, 100, 100}, variations[7]);
        }
    }
}
