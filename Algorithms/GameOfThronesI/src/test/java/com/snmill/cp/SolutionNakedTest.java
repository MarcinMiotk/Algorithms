package com.snmill.cp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void whetherAnyAnagramOfTheStringCanBeAPalindrome_aaabbbb() {
        boolean canBePalindrome = Solution.whetherAnyAnagramOfTheStringCanBeAPalindrome("aaabbbb");
        assertTrue(canBePalindrome);
    }

    @Test
    public void whetherAnyAnagramOfTheStringCanBeAPalindrome_cdefghmnopqrstuvw() {
        boolean canBePalindrome = Solution.whetherAnyAnagramOfTheStringCanBeAPalindrome("cdefghmnopqrstuvw");
        assertFalse(canBePalindrome);
    }

    @Test
    public void whetherAnyAnagramOfTheStringCanBeAPalindrome_cdcdcdcdeeeef() {
        boolean canBePalindrome = Solution.whetherAnyAnagramOfTheStringCanBeAPalindrome("cdcdcdcdeeeef");
        assertTrue(canBePalindrome);
    }
}
