package houseware.learn.testing.testng.groupsng;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertArrayEquals;

public class TestNGGroup {

    @Test(groups = {"groupA", "groupB"})
    public void jtestAssertEquals() {
        assertEquals("Strings should be equals", "equals", "equals");
    }

    @Test(groups = "groupB")
    public void jtestAssertFalse() {
        assertFalse("Should by false", false);
        assertFalse("Should by true", "".equals("not true"));
    }

    @Test(groups = "groupA")
    public void jtestAssertArrayEquals() {
        String textToByte = "byte";
        byte[] byteArray = textToByte.getBytes();
        byte[] expected = textToByte.getBytes();
        assertArrayEquals("byteArray it's not equals to expected", byteArray, expected);
    }
}
