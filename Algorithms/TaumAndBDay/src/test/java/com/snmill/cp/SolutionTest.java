package com.snmill.cp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void official_1() {
        String input = ""
                + "5\n"
                + "10 10\n"
                + "1 1 1\n"
                + "5 9\n"
                + "2 3 4\n"
                + "3 6\n"
                + "9 1 1\n"
                + "7 7\n"
                + "4 2 1\n"
                + "3 3\n"
                + "1 9 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("20\r\n"
                + "37\r\n"
                + "12\r\n"
                + "35\r\n"
                + "12", outContent.toString().trim());
    }

    @Test
    public void official_2() {
        String input = ""
                + "10\n"
                + "888 86\n"
                + "707984 191923 428029\n"
                + "158 367\n"
                + "352378 29540 508968\n"
                + "465 290\n"
                + "89143 588249 777837\n"
                + "865 107\n"
                + "970686 723490 741673\n"
                + "542 296\n"
                + "159324 460882 418824\n"
                + "324 560\n"
                + "8774 222583 196936\n"
                + "781 822\n"
                + "109021 339116 870096\n"
                + "401 273\n"
                + "622462 405778 415164\n"
                + "781 595\n"
                + "34806 736924 907195\n"
                + "642 140\n"
                + "641301 783327 158629";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("567022754\r\n"
                + "66516904\r\n"
                + "212043705\r\n"
                + "917056820\r\n"
                + "222774680\r\n"
                + "118040376\r\n"
                + "363898753\r\n"
                + "360384656\r\n"
                + "465653266\r\n"
                + "521381022", outContent.toString().trim());
    }

    @Test
    public void official_3() {
        String input = ""
                + "10\n"
                + "27984 1402\n"
                + "619246 615589 247954\n"
                + "95677 39394\n"
                + "86983 311224 588538\n"
                + "68406 12718\n"
                + "532909 315341 201009\n"
                + "15242 95521\n"
                + "712721 628729 396706\n"
                + "21988 67781\n"
                + "645748 353796 333199\n"
                + "22952 80129\n"
                + "502975 175136 340236\n"
                + "38577 3120\n"
                + "541637 657823 735060\n"
                + "5943 69851\n"
                + "674453 392925 381074\n"
                + "62990 61330\n"
                + "310144 312251 93023\n"
                + "11152 43844\n"
                + "788543 223872 972572";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("18192035842\r\n"
                + "20582630747\r\n"
                + "39331944938\r\n"
                + "70920116291\r\n"
                + "38179353700\r\n"
                + "25577754744\r\n"
                + "22947138309\r\n"
                + "31454478354\r\n"
                + "38686324390\r\n"
                + "18609275504", outContent.toString().trim());
    }

    @Test
    public void official_4() {
        String input = ""
                + "3\n"
                + "100 100\n"
                + "10000 10000 0\n"
                + "100 100\n"
                + "0 1000000 0\n"
                + "100 100\n"
                + "0 0 0";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2000000\r\n"
                + "0\r\n"
                + "0", outContent.toString().trim());
    }

}
