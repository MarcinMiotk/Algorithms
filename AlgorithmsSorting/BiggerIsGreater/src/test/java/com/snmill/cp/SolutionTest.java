package com.snmill.cp;

import com.snmill.cp.Solution.Pivot;
import static com.snmill.cp.Solution.decrementCounter;
import static com.snmill.cp.Solution.findMinimumButGreaterThan;
import static com.snmill.cp.Solution.incrementCounter;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    @Test
    public void ab_into_ba() {
        assertEquals("ba", Solution.rearrange("ab"));
    }

    @Test
    public void noanswer() {
        assertEquals("no answer", Solution.rearrange("bb"));
    }

    @Test
    public void counters_increments_a() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'a');
        incrementCounter(counters, 'c');
        assertEquals(1, counters[0]);
        assertEquals(1, counters[2]);
    }

    @Test
    public void counters_decrements_c() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'c');
        incrementCounter(counters, 'c');
        assertEquals(2, counters[2]);
        decrementCounter(counters, 'c');
        decrementCounter(counters, 'c');
        assertEquals(0, counters[2]);
    }

    @Test
    public void created_counters_table() {
        assertEquals(26, Solution.createEmptyCounters().length);
    }

    @Test
    public void findMinimumButGreaterThan_find_h() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'c');
        incrementCounter(counters, 'h');
        incrementCounter(counters, 'k');
        char found = findMinimumButGreaterThan(counters, 'd').get().charValue();
        assertEquals('h', found);
    }

    @Test
    public void findMinimumButGreaterThan_findNoCharacter() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'c');
        incrementCounter(counters, 'h');
        incrementCounter(counters, 'k');
        Optional<Character> found = findMinimumButGreaterThan(counters, 'k');
        assertFalse("Must be empty", found.isPresent());
    }

    @Test
    public void createAscendingStringWithCounters() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'c');
        incrementCounter(counters, 'd');
        incrementCounter(counters, 'a');
        incrementCounter(counters, 'k');
        incrementCounter(counters, 'a');

        String result = Solution.createAscendingStringWithCounters(counters);
        assertEquals("aacdk", result);
    }

    @Test
    public void findPivot_1() {
        int[] counters = Solution.createEmptyCounters();
        incrementCounter(counters, 'a');
        incrementCounter(counters, 'b');
        incrementCounter(counters, 'b');
        incrementCounter(counters, 'b');
        Optional<Pivot> found = Solution.findPivot(counters, "cabbb");

        assertEquals('b', found.get().character);
        assertEquals(1, found.get().index);
    }
}
