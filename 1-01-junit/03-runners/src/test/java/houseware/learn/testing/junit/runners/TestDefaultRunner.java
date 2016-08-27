package houseware.learn.testing.junit.runners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestDefaultRunner {

    @Test
    public void default_runner() {
        assertEquals("If you do not specify the runner, BlockJUnit4ClassRunner is the default runner ", "BlockJUnit4ClassRunner", "BlockJUnit4ClassRunner");
    }

    @Test
    public void default_version_runner() {
        assertEquals("Can you use Junit4.class, Junit3.class, etc. RunWith(Junit4.class) will always invoke the defautl JUnit runner) ", "JUnit4", "JUnit4");
    }

}
