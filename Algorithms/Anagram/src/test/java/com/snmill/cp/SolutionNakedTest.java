package com.snmill.cp;

import com.snmill.cp.Solution.TwoAsciiTablesForLeftAndRigtPartOfWord;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void evenLength() {
        String word = "aaabbb";
        int minimumChanges = Solution.minimumNumberOfCharactersOfTheFirstStringHeNeedsToChangeToEnableHimToMakeItAnAnagramOfTheSecondString(word);
        assertEquals(3, minimumChanges);
    }

    @Test
    public void oddLength() {
        String word = "abc";
        int minimumChanges = Solution.minimumNumberOfCharactersOfTheFirstStringHeNeedsToChangeToEnableHimToMakeItAnAnagramOfTheSecondString(word);
        assertEquals(-1, minimumChanges);
    }

    @Test
    public void createCountersTableFor_onceOccuredCharacters() {
        int[] asciiCounters = Solution.createCountersTableFor("abc", 0, 2);

        assertEquals(1, asciiCounters[0]);
        assertEquals(1, asciiCounters[1]);
        assertEquals(1, asciiCounters[2]);
        assertEquals(0, asciiCounters[3]);
        assertEquals(0, asciiCounters[4]);
    }

    @Test
    public void createCountersTableFor_onceOccuredCharactersAndOneDoubledCharacter() {
        int[] asciiCounters = Solution.createCountersTableFor("abca", 0, 3);

        assertEquals(2, asciiCounters[0]);
        assertEquals(1, asciiCounters[1]);
        assertEquals(1, asciiCounters[2]);
        assertEquals(0, asciiCounters[3]);
        assertEquals(0, asciiCounters[4]);
    }

    @Test
    public void createAsciiTablesForTwoPartsOfWord_for4characters() {
        Solution.TwoAsciiTablesForLeftAndRigtPartOfWord parts = Solution.createAsciiTablesForTwoPartsOfWord("abcd");

        assertEquals(1, parts.left[0]);
        assertEquals(1, parts.left[1]);
        assertEquals(0, parts.left[2]);
        assertEquals(0, parts.left[3]);
        //
        assertEquals(0, parts.right[0]);
        assertEquals(0, parts.right[1]);
        assertEquals(1, parts.right[2]);
        assertEquals(1, parts.right[3]);

    }

//    public void official_1() {
//        String input = ""
//                + "6\n"
//                + "aaabbb\n"
//                + "ab\n"
//                + "abc\n"
//                + "mnop\n"
//                + "xyyx\n"
//                + "xaxbbbxx";
//
//        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Solution.main(null);
//        assertEquals("3\r\n"
//                + "1\r\n"
//                + "-1\r\n"
//                + "2\r\n"
//                + "0\r\n"
//                + "1", outContent.toString().trim());
//    }
}
