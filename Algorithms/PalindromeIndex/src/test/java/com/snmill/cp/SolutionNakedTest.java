package com.snmill.cp;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void If_the_string_is_already_a_palindrome_then_print_minut1() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("aaa");
        Assert.assertEquals(-1, indexToRemove);
    }

    @Test
    public void shouldRemove_0_toHavePalindrome_from_baa() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("baa");
        Assert.assertEquals(0, indexToRemove);
    }

    @Test
    public void shouldRemove_1_toHavePalindrome_from_abaa() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("abaa");
        Assert.assertEquals(1, indexToRemove);
    }

    @Test
    public void shouldRemove_3_toHavePalindrome_from_aaab() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("aaab");
        Assert.assertEquals(3, indexToRemove);
    }

    @Test
    public void shouldRemove_3_toHavePalindrome_from_axab() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("axab");
        Assert.assertEquals(3, indexToRemove);
    }

    @Test
    public void shouldRemove_7_toHavePalindrome_from_abcaggadcba() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("abcaggadcba");
        Assert.assertEquals(7, indexToRemove);
    }

    @Test
    public void shouldRemove_5_toHavePalindrome_from_abcaadcba() {
        int indexToRemove = Solution.indexOfTheCharacterWhoseRemovalWillMakeTheStringPalindrome("abcaadcba");
        Assert.assertEquals(5, indexToRemove);
    }

}
