package houseware.learn.testing.junit.suites;

import houseware.learn.testing.junit.suites.utils.JTestAssertThat;
import houseware.learn.testing.junit.suites.utils.JTestAssertions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JTestAssertions.class,
        JTestAssertThat.class
})
public class SuitTest {
}
