package houseware.learn.testing.junit.basic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }
    @Test
    public void basicTest(){
        //asserts
    }
}
