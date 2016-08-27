package houseware.learn.testing.junit.suites;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Assertions types
 */
@RunWith(IgnoredNotAllowRunner.class)
public class TestAssertions {

    @Ignore
    @Test
    public void assert_Equals() {
        assertEquals("Strings should be equals", "equals", "equals");
    }

    @Test
    public void assert_False() {
        assertFalse("Should by false", false);
        assertFalse("Should by true", "".equals("not true"));
    }

}
