package houseware.learn.testing.json;


import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.Test;

import static net.javacrumbs.jsonunit.JsonAssert.*;
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static net.javacrumbs.jsonunit.core.Option.*;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertThat;

/**
 * @author fphilip@houseware.es
 */
public class TestJsonAsset {

    @Test
    public void assert_equals_two_docs() {
        assertJsonEquals("{\"test\":1}", "{\n\"foo\": 1\n}");
    }

    @Test
    public void assert_compare_part() {
        // compares only part
        assertJsonPartEquals("2", "{\"test\":[{\"value\":1},{\"value\":2}]}",
                "test[1].value");
    }

    @Test
    public void assert_equals_two_docs_TREATING_NULL_AS_ABSENT() {
        assertJsonEquals("{\"test\":{\"a\":1}}",
                "{\"test\":{\"a\":1, \"b\": null}}",
                when(TREATING_NULL_AS_ABSENT));

    }

    @Test
    public void assert_equals_IGNORING_VALUES() {
        assertJsonEquals("[{\"test\":1}, {\"test\":2}]",
                "[{\n\"test\": 1\n}, {\"TEST\": 4}]", when(IGNORING_VALUES));

    }

    @Test
    public void assert_equals_two_docs_with_no() {
        // Lenient parsing of expected value
        assertJsonEquals("{//Look ma, no quotation marks\n test:'value'}",
                "{\n\"test\": \"value\"\n}");
    }

    @Test
    public void assert_regex() {
        assertJsonEquals("{\"test\": \"${json-unit.regex}[A-Z]+\"}",
                "{\"test\": \"ABCD\"}");
    }

    @Test
    public void assert_equals() {
        assertJsonEquals("{\"test\":\"${json-unit.ignore}\"}",
                "{\n\"test\": {\"object\" : {\"another\" : 1}}}");

    }

    @Test
    public void case_TREATING_NULL_AS_ABSENT() {

//    TREATING_NULL_AS_ABSENT - fields with null values are equivalent to absent fields. For example, this test passes

        assertJsonEquals("{\"test\":{\"a\":1}}",
                "{\"test\":{\"a\":1, \"b\": null, \"c\": null}}",
                when(TREATING_NULL_AS_ABSENT));


    }

    @Test
    public void assert_equals_IGNORING_ARRAY_ORDER() {
//    IGNORING_ARRAY_ORDER - ignores order in arrays

        assertJsonEquals("{\"test\":[1,2,3]}",
                "{\"test\":[3,2,1]}",
                when(IGNORING_ARRAY_ORDER));


    }
    @Test

    public void assert_equals_IGNORING_EXTRA_ARRAY_ITEMS() {
//    IGNORING_EXTRA_ARRAY_ITEMS - ignores unexpected array items

        assertJsonEquals("{\"test\":[1,2,3]}",
                "{\"test\":[1,2,3,4]}",
                when(IGNORING_EXTRA_ARRAY_ITEMS));


        assertJsonEquals("{\"test\":[1,2,3]}",
                "{\"test\":[5,5,4,4,3,3,2,2,1,1]}",
                when(IGNORING_EXTRA_ARRAY_ITEMS, IGNORING_ARRAY_ORDER));


    }

    @Test
    public void assert_equals_IGNORING_EXTRA_FIELDS() {

        assertJsonEquals("{\"test\":{\"b\":2}}",
                "{\"test\":{\"a\":1, \"b\":2, \"c\":3}}",
                when(IGNORING_EXTRA_FIELDS));


    }


    @Test
    public void assert_that_IGNORING_ARRAY_ORDER_IGNORING_EXTRA_FIELDS() {
        assertJsonEquals("{\"test\":[{\"key\":1},{\"key\":2},{\"key\":3}]}",
                "{\"test\":[{\"key\":3},{\"key\":2, \"extraField\":2},{\"key\":1}]}",
                when(IGNORING_ARRAY_ORDER, IGNORING_EXTRA_FIELDS));


    }

    @Test
    public void assert_that_IGNORING_EXTRA_FIELDS() {
//    In Hamcrest assertion you can set the option like this

        assertThat("{\"test\":{\"a\":1, \"b\":2, \"c\":3}}",
                jsonEquals("{\"test\":{\"b\":2}}").when(IGNORING_EXTRA_FIELDS));

    }

    @Test
    public void assert_that_IGNORING_ARRAY_ORDER_IGNORING_EXTRA_FIELDS_global() {
//    For standard asserts and Hamcrest matchers, it is possible to set the configuration globally

        JsonAssert.setOptions(IGNORING_ARRAY_ORDER, IGNORING_EXTRA_FIELDS);
//    In fluent assertion, you can set options in the following way

        assertJsonEquals("{\"test\":{\"a\":1, \"b\":2, \"c\":3}}", "{\"test\":{\"b\":2}}");

    }

    @Test
    public void assert_that_IGNORING_ARRAY_ORDER_IGNORING_EXTRA_FIELDS_fluent_global() {
//    For standard asserts and Hamcrest matchers, it is possible to set the configuration globally

        JsonAssert.setOptions(IGNORING_ARRAY_ORDER, IGNORING_EXTRA_FIELDS);
//    In fluent assertion, you can set options in the following way

        assertThatJson("{\"test\":{\"a\":1, \"b\":2, \"c\":3}}")
                .when(IGNORING_EXTRA_FIELDS).isEqualTo("{\"test\":{\"b\":2}}");

    }


    @Test
    public void numeric_comparison_tolerance() {
        assertJsonEquals("1", "\n1.009\n", withTolerance(0.01));
//    or globally

//    or for fluent assertions

    }


    @Test

    public void numeric_comparison_tolerance_global() {


        JsonAssert.setTolerance(0.01);
        assertJsonEquals("1", "\n1.009\n");

    }

}
