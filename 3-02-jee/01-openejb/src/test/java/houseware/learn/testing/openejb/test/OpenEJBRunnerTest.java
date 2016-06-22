package houseware.learn.testing.openejb.test;

import houseware.learn.testing.jee.MyService;
import org.apache.openejb.junit.OpenEjbRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.LocalBean;
import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.assertNotNull;

/**
 * @author fphilip@houseware.es
 */
@RunWith(OpenEjbRunner.class)
@LocalBean
public class OpenEJBRunnerTest extends OpenEJBSimpleTest {


    EJBContainer container;
    MyService myService;


    @Test
    public void is_inject_ok() {
        assertNotNull(container);
    }

}
