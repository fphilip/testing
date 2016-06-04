import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersTestNameAscending {

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
