package houseware.learn.testing.junit.timeouts;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import java.util.concurrent.TimeUnit;

public class TestTimeoutWithRule {

    @Rule
    public Timeout timeout = Timeout.seconds(3);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testFailforTimeout() throws Exception {
        TimeUnit.SECONDS.sleep(4);
    }
}
