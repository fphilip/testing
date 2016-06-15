package houseware.learn.testing.json;

import org.junit.Test;

import static java.math.BigDecimal.valueOf;
import static net.javacrumbs.jsonunit.JsonMatchers.*;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * @author fphilip@houseware.es
 */
public class TestJsonHamcrests {


    @Test
    public void assert_that() {
        assertThat("{\"test\":1}", jsonEquals("{\"test\": 1}"));
        assertThat("{\"test\":1}", jsonPartEquals("test", 1));
        assertThat("{\"test\":[1, 2, 3]}", jsonPartEquals("test[0]", 1));

        assertThat("{\"test\":{\"a\":1, \"b\":2, \"c\":3}}",
                jsonEquals("{\"test\":{\"b\":2}}").when(IGNORING_EXTRA_FIELDS));

        assertThat("{\"test\":1}", jsonPartMatches("test", is(valueOf(1))));
    }

    @Test
    public void assert_that_harmcrest() {

        assertThatJson("{\"test\":\"one\"}").node("test")
                .matches(equalTo("one"));
    }

    @Test
    public void assert_that_harmcrest2() {
        assertThatJson("{\"test\":[1,2,3]}").node("test").matches(hasItem(valueOf(1)));

        assertThatJson("{\"test\":[{\"value\":1},{\"value\":2},{\"value\":3}]}")
                .node("test")
                .matches(everyItem(jsonPartMatches("value", lessThanOrEqualTo(valueOf(4)))));

    }


    public void ignore() {
        assertThatJson("{\"test\":1.10001}").node("test")
                .matches(closeTo(valueOf(1.1), valueOf(0.001)));

    }

    public void assert_that_() {
        assertThatJson("{\"test\":[{\"value\":1},{\"value\":2},{\"value\":3}]}")
                .node("test")
                .matches(everyItem(jsonPartMatches("value", lessThanOrEqualTo(valueOf(4)))));
    }

}
