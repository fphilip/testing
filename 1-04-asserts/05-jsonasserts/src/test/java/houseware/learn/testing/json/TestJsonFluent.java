package houseware.learn.testing.json;

import org.junit.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_VALUES;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

/**
 * @author fphilip@houseware.es
 */
public class TestJsonFluent {


    @Test
    public void assert_that_isEqualTo() {

// compares entire documents
        assertThatJson("{\"test\":1}").isEqualTo("{\"test\":2}");
    }

    @Test
    public void assert_that_part_isEqualTo() {
// compares only parts of the document
        assertThatJson("{\"test1\":2, \"test2\":1}")
                .node("test1").isEqualTo(2)
                .node("test2").isEqualTo(2);
    }

    @Test
    public void assert_that_part_index_isEqualTo() {

        assertThatJson("{\"root\":{\"test\":[1,2,3}}")
                .node("root.test[0]").isEqualTo(1);

    }

    @Test  //only the structure
    public void assert_that_IGNORING_VALUES() {
        assertThatJson("{\"test\":1}")
                // Options have to be specified before the assertion
                .when(IGNORING_VALUES)
                .isEqualTo("{\"test\":21}");

    }

    @Test  //only the structure
    public void assert_that_IGNORING_VALUES_particuar_with_placeholder() {
// ignores a value
        assertThatJson("{\"test\":1}").isEqualTo("{\"test\":\"${json-unit.ignore}\"}");

    }

    @Test
    public void assert_that_IGNORING_EXTRA_FIELDS() {
        assertThatJson("{\"test\":{\"a\":1, \"b\":2, \"c\":3}}")
                // Options have to be specified before the assertion
                .when(IGNORING_EXTRA_FIELDS)
                .isEqualTo("{\"test\":{\"b\":2}}");

// array length comparison
        assertThatJson("{\"test\":[1,2,3]}").node("test")
                .isArray().ofLength(2);

    }


    @Test
    public void numeric_comparison_fluent() {
        assertThatJson("{\"test\":1.00001}").node("test").withTolerance(0.001).isEqualTo(1);
//    Or you can use Hamcrest matcher


    }
}
