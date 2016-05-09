package com.snmill.cp;

import com.snmill.cp.Solution.LeftToRigthIterator;
import com.snmill.cp.Solution.RightToLeftIterator;
import static com.snmill.cp.Solution.minimumOperationsToCreatePalindrome;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void oddWord() {
        int minimum = minimumOperationsToCreatePalindrome("abc");
        assertEquals(2, minimum);
    }

    @Test
    public void evenWord() {
        int minimum = minimumOperationsToCreatePalindrome("abcd");
        assertEquals(4, minimum);
    }

    @Test
    public void LeftToRigthIterator_3characters() {
        LeftToRigthIterator iterator = new LeftToRigthIterator("abc");
        assertEquals((int) 'a', (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void RightToLeftIterator_3characters() {
        RightToLeftIterator iterator = new RightToLeftIterator("abc");
        assertEquals((int) 'c', (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void LeftToRigthIterator_4characters() {
        LeftToRigthIterator iterator = new LeftToRigthIterator("abcd");
        assertEquals((int) 'a', (int) iterator.next());
        assertEquals((int) 'b', (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void RightToLeftIterator_4characters() {
        RightToLeftIterator iterator = new RightToLeftIterator("abcd");
        assertEquals((int) 'd', (int) iterator.next());
        assertEquals((int) 'c', (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void Iterator_9characters() {
        String word = "abcdefger";
        RightToLeftIterator right = new RightToLeftIterator(word);
        LeftToRigthIterator left = new LeftToRigthIterator(word);
        //
        assertEquals((int) 'a', (int) left.next());
        assertEquals((int) 'b', (int) left.next());
        assertEquals((int) 'c', (int) left.next());
        assertEquals((int) 'd', (int) left.next());
        //
        assertEquals((int) 'r', (int) right.next());
        assertEquals((int) 'e', (int) right.next());
        assertEquals((int) 'g', (int) right.next());
        assertEquals((int) 'f', (int) right.next());
    }

}
