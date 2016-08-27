package houseware.learn.testing.junit.basic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBeforeAfterClass {

    @BeforeClass
    public static void before_class() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void after_class() {
        System.out.println("@AfterClass");
    }

    @Test
    public void dummy() {
        //asserts
    }
}
