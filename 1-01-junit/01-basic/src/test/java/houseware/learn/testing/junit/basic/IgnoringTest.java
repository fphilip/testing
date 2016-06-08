package houseware.learn.testing.junit.basic;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class IgnoringTest {

    @Ignore("jtestAssertEquals is ignored")
    @Test
    public void jtestAssertEquals() {
        assertEquals("Strings should be equals", "equals", "equals");
    }

    @Test
    public void jtestAssertFalse() {
        assertFalse("Should by false", false);
        assertFalse("Should by true", "".equals("not true"));
    }

    @Ignore("jtestAssertArrayEquals is ignored")
    @Test
    public void jtestAssertArrayEquals() {
        String textToByte = "byte";
        byte[] byteArray = textToByte.getBytes();
        byte[] expected = textToByte.getBytes();
        assertArrayEquals("byteArray it's not equals to expected", byteArray, expected);
    }

}
