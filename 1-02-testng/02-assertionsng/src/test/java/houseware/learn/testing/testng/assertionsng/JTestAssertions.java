package houseware.learn.testing.testng.assertionsng;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

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
        String string = new String();
        String anotherString = new String();
        assertNotSame("Should not be same String", new String(), new String());
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
        Long objectLong = new Long(5l);
        assertSame(objectLong, objectLong);
    }

    @Test
    public void jtestAssertTrue() {
        assertTrue("Should by true", true);
        assertTrue("Should by true", "".equals(""));
    }


}
