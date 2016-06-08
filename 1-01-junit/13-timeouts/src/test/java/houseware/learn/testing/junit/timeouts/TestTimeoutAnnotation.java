package houseware.learn.testing.junit.timeouts;

import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import java.util.concurrent.TimeUnit;

public class TestTimeoutAnnotation {

    @Test(timeout = 3000)
    public void timeout() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test(timeout = 5000)
    public void timeout_02() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }

    @Test(timeout = 2000)
    public void fail_for_timeout() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }
}
