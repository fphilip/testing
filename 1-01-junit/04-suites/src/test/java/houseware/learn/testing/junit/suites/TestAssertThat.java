package houseware.learn.testing.junit.suites;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Another assert type with hamcrest
 */
public class TestAssertThat {

    @Test
    public void testAssertThatAllOf() {
        assertThat("work text", allOf(containsString("k text"), endsWith("xt"), startsWith("wo")));
    }

}
