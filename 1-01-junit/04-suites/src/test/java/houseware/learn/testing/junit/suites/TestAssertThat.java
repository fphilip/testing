package houseware.learn.testing.junit.suites;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Another assert type with hamcrest
 */
public class TestAssertThat {

    private static String TEXT = "work text";

    @Test
    public void testAssertThatAllOf() {
        assertThat(TEXT, allOf(containsString("k text"), endsWith("xt"), startsWith("wo")));
    }

}
