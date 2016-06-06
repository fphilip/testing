package houseware.learn.testing.testng.orderng;

import org.testng.annotations.Test;

public class OrderWithGroup {

    @Test
    public void testB() {
        System.out.println("testB");
    }

    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Test
    public void testC() {
        System.out.println("testC");
    }
}
