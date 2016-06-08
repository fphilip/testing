package houseware.learn.testing.junit.matchers;

import houseware.learn.testing.junit.matchers.utils.Utils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Another assert type with hamcrest
 */
public class TestAssertThat {

    private static String TEXT = "work text";

    @Test
    public void testAssertThatAllOf(){
        assertThat(TEXT, allOf(containsString("k text"), endsWith("xt"), startsWith("wo")));
    }

    @Test
    public void testAssertThatBoth(){
        assertThat(TEXT, both(containsString("o")).and(containsString("x")));
    }

    @Test
    public void testAssertThatAnyOf(){
        assertThat(TEXT, anyOf(equalTo(TEXT), equalTo("nop")));
        assertThat(TEXT, anyOf(equalTo("fail"), equalTo("nop"), containsString("work")));
    }

    @Test
    public void testAssertThatContainsString(){
        assertThat(TEXT, containsString("ork"));
    }

    @Test
    public void testAssertThatEqualTo(){
        assertThat(TEXT, equalTo("work text"));
    }

    @Test
    public void testAssertThatEveryItem(){
        assertThat(Utils.getStringList(), everyItem(containsString("c")));
        assertThat(Utils.getStringList(), everyItem(containsString("o")));
    }

    @Test
    public void testAssertThatHasItems(){
        assertThat(Utils.getStringList(), hasItems("ceo", "eco"));
        assertThat(Utils.getStringList(), hasItems("ceo", "eco", "collection"));
    }

    @Test
    public void testAssertThatNot(){
        assertThat(TEXT, not(equalTo("eco")));
    }

    @Test
    public void testAssertThatSameInstance(){
        Object object = new Object();
        assertThat(object, sameInstance(object));
    }

    @Test
    public void testAssertThatStartsWith(){
        assertThat(TEXT, startsWith("wo"));
    }

}
