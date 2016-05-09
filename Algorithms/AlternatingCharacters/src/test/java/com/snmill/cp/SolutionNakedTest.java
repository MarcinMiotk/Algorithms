package com.snmill.cp;

import static com.snmill.cp.Solution.minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class SolutionNakedTest {

    @Test
    public void minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent_AAAA() {
        int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent("AAAA");
        assertEquals(3, minimum);
    }

    @Test
    public void minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent_BBBBB() {
        int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent("BBBBB");
        assertEquals(4, minimum);
    }

    @Test
    public void minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent_ABABABAB() {
        int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent("ABABABAB");
        assertEquals(0, minimum);
    }

    @Test
    public void minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent_BABABA() {
        int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent("BABABA");
        assertEquals(0, minimum);
    }
    
    @Test
    public void minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent_AAABBB() {
        int minimum = minimumNumberOfDeletionsRequiredToHaveConsecutiveCharactersDifferent("AAABBB");
        assertEquals(4, minimum);
    }    
}
