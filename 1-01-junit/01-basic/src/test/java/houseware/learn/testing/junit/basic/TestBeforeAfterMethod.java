package houseware.learn.testing.junit.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBeforeAfterMethod {

    @Before
    public void before_class() {
        System.out.println("@Before");
    }

    @After
    public void after_class() {
        System.out.println("@After");
    }

    @Test
    public void dummy_1() {
        System.out.println("@dummy_1");
    }

    @Test
    public void dummy_2() {
        System.out.println("@dummy_2");
    }

    @Test
    public void dummy_3() {
        System.out.println("@dummy_3");
    }
}
