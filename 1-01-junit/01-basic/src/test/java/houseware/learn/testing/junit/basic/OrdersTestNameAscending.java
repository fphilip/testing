package houseware.learn.testing.junit.basic;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersTestNameAscending {

    @Test
    public void case_B() {
        System.out.println("case_B");
    }

    @Test
    public void case_A() {
        System.out.println("case_A");
    }

    @Test
    public void case_C() {
        System.out.println("case_C");
    }


}
