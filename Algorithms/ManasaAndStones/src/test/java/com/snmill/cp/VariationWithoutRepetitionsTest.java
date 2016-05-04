package com.snmill.cp;

import com.snmill.cp.Solution.VariationWithoutRepetitions;
import java.util.Iterator;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class VariationWithoutRepetitionsTest {

    @Test
    public void variationWithoutRepetitions_count() {
        int n = 2;
        int k = 3;
        Iterator iterator = new VariationWithoutRepetitions(3, 2);
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(8, count);
    }

    @Test
    public void variationWithoutRepetitions_object_is_array_with_3_elements() {
        int n = 2;
        int k = 3;
        Iterator iterator = new VariationWithoutRepetitions(3, 2);
        int[] indexes = (int[]) iterator.next();
        assertEquals(3, indexes.length);
    }

    @Test
    public void variationWithoutRepetitions_object_is_array_with_4_elements() {
        int n = 2;
        int k = 4;
        Iterator iterator = new VariationWithoutRepetitions(4, 2);
        int[] indexes = (int[]) iterator.next();
        assertEquals(4, indexes.length);
    }

    @Test
    public void variationWithoutRepetitions_valid_variations_for_n2_k3() {
        int n = 2;
        int k = 3;
        Iterator iterator = new VariationWithoutRepetitions(3, 2);
        assertArrayEquals(new int[]{0, 0, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 0, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 1}, (int[]) iterator.next());
    }

    @Test
    public void variationWithoutRepetitions_valid_variations_for_n2_k4_print_only() {
        int n = 2;
        int k = 4;
        Iterator iterator = new VariationWithoutRepetitions(4, 2);

        while (iterator.hasNext()) {
            int[] indexes = (int[]) iterator.next();

            StringBuilder sb = new StringBuilder();
            for (int i = indexes.length - 1; i >= 0; i--) {
                sb.append(indexes[i]);
            }
            System.out.println(sb.toString());
        }
    }

    @Test
    public void variationWithoutRepetitions_valid_variations_for_n2_k4() {
        int n = 2;
        int k = 4;
        Iterator iterator = new VariationWithoutRepetitions(4, 2);

        assertArrayEquals(new int[]{0, 0, 0, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 0, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 0, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 0, 0}, (int[]) iterator.next());

        assertArrayEquals(new int[]{0, 0, 1, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 1, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 1, 0}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 1, 0}, (int[]) iterator.next());

        assertArrayEquals(new int[]{0, 0, 0, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 0, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 0, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 0, 1}, (int[]) iterator.next());

        assertArrayEquals(new int[]{0, 0, 1, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 0, 1, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{0, 1, 1, 1}, (int[]) iterator.next());
        assertArrayEquals(new int[]{1, 1, 1, 1}, (int[]) iterator.next());
    }

    @Test
    public void variationWithoutRepetitions_valid_variations_for_n3_k3_print_only() {
        int n = 3;
        int k = 3;
        Iterator iterator = new VariationWithoutRepetitions(k, n);

        while (iterator.hasNext()) {
            int[] indexes = (int[]) iterator.next();

            StringBuilder sb = new StringBuilder();
            for (int i = indexes.length - 1; i >= 0; i--) {
                sb.append(indexes[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
