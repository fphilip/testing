package houseware.learn.testing.openejb.test;

import houseware.learn.testing.jee.MyService;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.LocalBean;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

/**
 * @author fphilip@houseware.es
 */
@LocalBean
public class OpenEJBInjectTest extends OpenEJBSimpleTest {
//    @EJB
    MyService myService;

    @Before
    public void inject() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @Test
    public void is_inject_ok() {
        assertNotNull(myService);
    }

}
