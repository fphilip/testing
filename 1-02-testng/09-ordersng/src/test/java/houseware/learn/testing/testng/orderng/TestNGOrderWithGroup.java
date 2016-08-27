package houseware.learn.testing.testng.orderng;

import org.testng.annotations.Test;

public class TestNGOrderWithGroup {

    @Test
    public void case_B() {
        System.out.println("testB");
    }

    @Test
    public void case_A() {
        System.out.println("testA");
    }

    @Test
    public void case_C() {
        System.out.println("testC");
    }
}
