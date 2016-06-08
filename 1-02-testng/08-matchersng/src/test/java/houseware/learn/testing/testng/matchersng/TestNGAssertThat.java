package houseware.learn.testing.testng.matchersng;

import houseware.learn.testing.testng.matchersng.utils.Utils;
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
    public void assert_thatAllOf(){
        assertThat(TEXT, allOf(containsString("k text"), endsWith("xt"), startsWith("wo")));
    }

    @Test
    public void assert_ThatBoth(){
        assertThat(TEXT, both(containsString("o")).and(containsString("x")));
    }

    @Test
    public void assert_ThatAnyOf(){
        assertThat(TEXT, anyOf(equalTo(TEXT), equalTo("nop")));
        assertThat(TEXT, anyOf(equalTo("fail"), equalTo("nop"), containsString("work")));
    }

    @Test
    public void assert_ThatContainsString(){
        assertThat(TEXT, containsString("ork"));
    }

    @Test
    public void assert_that_EqualTo(){
        assertThat(TEXT, equalTo("work text"));
    }

    @Test
    public void assert_that_EveryItem(){
        assertThat(Utils.getStringList(), everyItem(containsString("c")));
        assertThat(Utils.getStringList(), everyItem(containsString("o")));
    }

    @Test
    public void assert_that_HasItems(){
        assertThat(Utils.getStringList(), hasItems("ceo", "eco"));
        assertThat(Utils.getStringList(), hasItems("ceo", "eco", "collection"));
    }

    @Test
    public void assert_that_Not(){
        assertThat(TEXT, not(equalTo("eco")));
    }

    @Test
    public void assert_that_SameInstance(){
        Object object = new Object();
        assertThat(object, sameInstance(object));
    }

    @Test
    public void assert_that_StartsWith(){
        assertThat(TEXT, startsWith("wo"));
    }

}
