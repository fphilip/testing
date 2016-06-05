package houseware.learn.testing.junit.assertions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Assertions types
 */
public class JTestAssertions {

    @Test
    public void jtestAssertEquals() {
        assertEquals("Strings should be equals", "equals", "equals");
    }

    @Test
    public void jtestAssertFalse() {
        assertFalse("Should by false", false);
        assertFalse("Should by true", "".equals("not true"));
    }

    @Test
    public void jtestAssertArrayEquals() {
        String textToByte = "byte";
        byte[] byteArray = textToByte.getBytes();
        byte[] expected = textToByte.getBytes();
        assertArrayEquals("byteArray it's not equals to expected", byteArray, expected);
    }

    @Test
    public void jtestAssertNotSame() {
        Integer integer = 900;
        Integer anotherInteger = 900;
        assertNotSame("Should not be same String", integer, anotherInteger);
    }

    @Test
    public void jtestAssertNotNull() {
        String text = "";
        assertNotNull("Text is null", text);

        Object object = new Object();
        assertNotNull("Text is null", object);
    }

    @Test
    public void jtestAssertNull() {
        assertNull("Should be null", null);
    }

    @Test
    public void jtestAssertSame() {
        Long objectLong = 5L;
        assertSame(objectLong, objectLong);
    }

    @Test
    public void jtestAssertTrue() {
        assertTrue("Should by true", true);
    }


}
