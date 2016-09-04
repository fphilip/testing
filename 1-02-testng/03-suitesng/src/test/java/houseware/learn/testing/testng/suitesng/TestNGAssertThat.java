package houseware.learn.testing.testng.suitesng;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class TestNGAssertThat {

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
        assertThat(Utils.getStringList(), hasItems("ceol", "eco"));
        assertThat(Utils.getStringList(), hasItems("ceol", "eco", "collection"));
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
