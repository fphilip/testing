package houseware.learn.testing.junit.suites.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Assertions types
 */
public class JTestAssertions {

    @Test
    public void assert_Equals() {
        assertEquals("Strings should be equals", "equals", "equals");
    }

    @Test
    public void assert_False() {
        assertFalse("Should by false", false);
        assertFalse("Should by true", "".equals("not true"));
    }

    @Test
    public void assert_ArrayEquals() {
        String textToByte = "byte";
        byte[] byteArray = textToByte.getBytes();
        byte[] expected = textToByte.getBytes();
        assertArrayEquals("byteArray it's not equals to expected", byteArray, expected);
    }

    @Test
    public void assert_NotSame() {
        String string = new String("A");
        String anotherString = new String("A");
        assertNotSame("Should not be same String", string, anotherString);
    }


    @Test (expected = AssertionError.class)
    public void assert_the_extrange_string_case() {
        String string = "A";
        String anotherString = "A";
        assertNotSame("Should not be same String", string, anotherString);
    }


    @Test
    public void assert_NotNull() {
        String text = "";
        assertNotNull("Text is null", text);

        Object object = new Object();
        assertNotNull("Text is null", object);
    }

    @Test
    public void assert_Null() {
        assertNull("Should be null", null);
    }

    @Test
    public void assert_Same() {
        Long objectLong = 5l;
        assertSame("Should be same",objectLong, objectLong);
    }

    @Test
    public void assert_True() {
        Long objectLong = 5l;
        assertTrue("Should by true", true);
        assertTrue("Should by true", objectLong.equals(5l));
    }





}
