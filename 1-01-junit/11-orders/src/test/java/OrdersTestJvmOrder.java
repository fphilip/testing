import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class OrdersTestJvmOrder {
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
