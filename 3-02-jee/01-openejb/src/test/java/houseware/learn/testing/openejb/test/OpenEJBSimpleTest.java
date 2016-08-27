package houseware.learn.testing.openejb.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @author fphilip@houseware.es
 */
public class OpenEJBSimpleTest {

    protected static EJBContainer container;

    @BeforeClass
    public static void start() {
        Properties o = new Properties();
        o.put("openejb.deployments.classpath.include", ".*(test).*");
        container = EJBContainer.createEJBContainer(o);
    }

    @Before
    public void inject() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @AfterClass
    public static void stop() {
        if (container != null) {
            container.close();
            container = null;
        }
    }

    @Test
    public void is_container_ok() {
        container.getContext();
    }

}
