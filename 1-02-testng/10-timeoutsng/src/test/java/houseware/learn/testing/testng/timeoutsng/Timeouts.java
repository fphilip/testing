package houseware.learn.testing.testng.timeoutsng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Timeouts {

    @Test(timeOut = 3000)
    public void testTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test(timeOut = 5000)
    public void testTimeout_02() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }

    @Test(timeOut = 2000)
    public void testFailforTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }
}
