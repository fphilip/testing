package houseware.learn.testing.junit.runners;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(OurRunner.class)
public class TestOurRunner {

    @Test   @Ignore
    public void my_ignored_test(){
        throw new AssertionError("I'm Ignored!!!!!");
    }


}
