package houseware.learn.testing.junit.matchers;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void testAssertThatBoth() {
        assertThat(TEXT, both(containsString("o")).and(containsString("x")));
    }

    @Test
    public void testAssertThatAnyOf() {
        assertThat(TEXT, anyOf(equalTo(TEXT), equalTo("nop")));
        assertThat(TEXT, anyOf(equalTo("fail"), equalTo("nop"), containsString("work")));
    }

    @Test
    public void testAssertThatContainsString() {
        assertThat(TEXT, containsString("ork"));
    }

    @Test
    public void testAssertThatEqualTo() {
        assertThat(TEXT, equalTo("work text"));
    }

    @Test
    public void testAssertThatEveryItem() {
        assertThat(getStringList(), everyItem(containsString("c")));
        assertThat(getStringList(), everyItem(containsString("o")));
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(getStringList(), hasItems("ceox", "eco"));
        assertThat(getStringList(), hasItems("ceox", "eco", "collection"));
    }

    @Test
    public void testAssertThatNot() {
        assertThat(TEXT, not(equalTo("eco")));
    }

    @Test
    public void testAssertThatSameInstance() {
        Object object = new Object();
        assertThat(object, sameInstance(object));
    }

    @Test
    public void testAssertThatStartsWith() {
        assertThat(TEXT, startsWith("wo"));
    }

    public static List<String> getStringList() {
        List<String> list = new LinkedList<>();
        list.add("ceox");
        list.add("eco");
        list.add("collection");
        return list;
    }
}
