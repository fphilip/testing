package houseware.learn.testing.junit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAssertions.class,
        TestAssertThat.class
})
public class TestSuit {
}
