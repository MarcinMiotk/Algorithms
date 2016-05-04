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
                + "2\n"
                + "3\n"
                + "1\n"
                + "2\n"
                + "4\n"
                + "10\n"
                + "100";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("2 3 4\r\n"
                + "30 120 210 300", outContent.toString().trim());
    }

    @Test
    public void official_2_failed_at_first_time_bacause_of_runtime() {
        String input = ""
                + "5\n"
                + "58\n"
                + "69\n"
                + "24\n"
                + "83\n"
                + "86\n"
                + "81\n"
                + "73\n"
                + "25\n"
                + "25\n"
                + "12\n"
                + "73\n"
                + "82\n"
                + "5\n"
                + "3\n"
                + "23";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("1368 1413 1458 1503 1548 1593 1638 1683 1728 1773 1818 1863 1908 1953 1998 2043 2088 2133 2178 2223 2268 2313 2358 2403 2448 2493 2538 2583 2628 2673 2718 2763 2808 2853 2898 2943 2988 3033 3078 3123 3168 3213 3258 3303 3348 3393 3438 3483 3528 3573 3618 3663 3708 3753 3798 3843 3888 3933\r\n"
                + "6642 6647 6652 6657 6662 6667 6672 6677 6682 6687 6692 6697 6702 6707 6712 6717 6722 6727 6732 6737 6742 6747 6752 6757 6762 6767 6772 6777 6782 6787 6792 6797 6802 6807 6812 6817 6822 6827 6832 6837 6842 6847 6852 6857 6862 6867 6872 6877 6882 6887 6892 6897 6902 6907 6912 6917 6922 6927 6932 6937 6942 6947 6952 6957 6962 6967 6972 6977 6982 6987 6992 6997 7002 7007 7012 7017 7022 7027 7032 7037 7042 7047 7052\r\n"
                + "1800\r\n"
                + "803 812 821 830 839 848 857 866 875 884 893 902\r\n"
                + "12 32 52 72 92", outContent.toString().trim());
    }

    @Test
    public void official_3_failed_at_first_time_bacause_of_wrong_answer() {
        String input = ""
                + "5\n"
                + "9\n"
                + "25\n"
                + "59\n"
                + "18\n"
                + "28\n"
                + "28\n"
                + "12\n"
                + "26\n"
                + "35\n"
                + "63\n"
                + "97\n"
                + "39\n"
                + "72\n"
                + "16\n"
                + "82";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Solution.main(null);
        assertEquals("200 234 268 302 336 370 404 438 472\r\n"
                + "476\r\n"
                + "286 295 304 313 322 331 340 349 358 367 376 385\r\n"
                + "2418 2476 2534 2592 2650 2708 2766 2824 2882 2940 2998 3056 3114 3172 3230 3288 3346 3404 3462 3520 3578 3636 3694 3752 3810 3868 3926 3984 4042 4100 4158 4216 4274 4332 4390 4448 4506 4564 4622 4680 4738 4796 4854 4912 4970 5028 5086 5144 5202 5260 5318 5376 5434 5492 5550 5608 5666 5724 5782 5840 5898 5956 6014\r\n"
                + "1136 1202 1268 1334 1400 1466 1532 1598 1664 1730 1796 1862 1928 1994 2060 2126 2192 2258 2324 2390 2456 2522 2588 2654 2720 2786 2852 2918 2984 3050 3116 3182 3248 3314 3380 3446 3512 3578 3644 3710 3776 3842 3908 3974 4040 4106 4172 4238 4304 4370 4436 4502 4568 4634 4700 4766 4832 4898 4964 5030 5096 5162 5228 5294 5360 5426 5492 5558 5624 5690 5756 5822", outContent.toString().trim());
    }

    @Test
    public void variationsWithRepetitions_for_2_2_is_8() {
        assertEquals(8, Solution.variationsWithRepetitions(3, 2));
    }

    @Test
    public void variationsWithRepetitions_8_variations_for_k3() {
        int k = 3;
        int[] n = new int[]{10, 100};
        int[][] variations = Solution.variationsWithRepetitions(k, n);
        assertEquals(8, variations.length);
        assertEquals(3, variations[0].length);
    }

    @Test
    public void variationsWithRepetitions_8_variations_for_k3_check_all_values() {
        int k = 3;
        int[] n = new int[]{10, 100};
        int[][] variations = Solution.variationsWithRepetitions(k, n);
        assertEquals(8, variations.length);
        assertEquals(3, variations[0].length);

        assertArrayEquals(new int[]{10, 10, 10}, variations[0]);
        assertArrayEquals(new int[]{100, 10, 10}, variations[1]);
        assertArrayEquals(new int[]{10, 100, 10}, variations[2]);
        assertArrayEquals(new int[]{100, 100, 10}, variations[3]);
        assertArrayEquals(new int[]{10, 10, 100}, variations[4]);
        assertArrayEquals(new int[]{100, 10, 100}, variations[5]);
        assertArrayEquals(new int[]{10, 100, 100}, variations[6]);
        assertArrayEquals(new int[]{100, 100, 100}, variations[7]);

    }

}
