package houseware.learn.testing.junit.timeouts;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeoutTestAnnotation {

    @Test(timeout = 3000)
    public void testTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test(timeout = 5000)
    public void testTimeout_02() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }

    @Test(timeout = 2000)
    public void testFailforTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }
}
