package houseware.learn.testing.jsfunit;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.apache.cactus.ServletTestCase;
import org.jboss.jsfunit.jsfsession.JSFSession;

import java.io.IOException;

public class TestJSFUnit extends ServletTestCase {

    public static Test suite() {
        System.setProperty("cactus.contextURL","http://localhost:8080/showcase");
        return new TestSuite(TestJSFUnit.class);
    }
    public void test_01() throws IOException {
        new JSFSession("/showcase/index.xhtml");
        System.out.println();
    }
}
