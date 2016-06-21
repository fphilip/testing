package houseware.learn.testing.openejb.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

/**
 * @author fphilip@houseware.es
 */
public class OpenEJBSimpleTest {

    static EJBContainer container;

    @BeforeClass
    public static void start() {
        container = EJBContainer.createEJBContainer();
    }

    @Before
    public void inject() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @AfterClass
    public static void stop() {
        container.close();
    }

}
