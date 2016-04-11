package com.snmill.cp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class SolutionTest {

    public SolutionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConvertTo24Hours() {
        assertEquals("00:00:00", Solution.convertTo24Hour("12:00:00AM"));
        assertEquals("12:00:00", Solution.convertTo24Hour("12:00:00PM"));

        assertEquals("19:05:45", Solution.convertTo24Hour("07:05:45PM"));
        assertEquals("13:05:45", Solution.convertTo24Hour("01:05:45PM"));
        assertEquals("14:05:45", Solution.convertTo24Hour("02:05:45PM"));
        assertEquals("22:06:46", Solution.convertTo24Hour("10:06:46PM"));
        assertEquals("12:06:46", Solution.convertTo24Hour("12:06:46PM"));
        assertEquals("07:05:45", Solution.convertTo24Hour("07:05:45AM"));
        assertEquals("01:05:45", Solution.convertTo24Hour("01:05:45AM"));
        assertEquals("02:05:45", Solution.convertTo24Hour("02:05:45AM"));
        assertEquals("10:06:46", Solution.convertTo24Hour("10:06:46AM"));
    }

}
