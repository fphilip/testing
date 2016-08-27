package houseware.learn.testing.arquillian.test;

import houseware.learn.testing.arquillian.books.LocaleManager;
import houseware.learn.testing.arquillian.books.TimeService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Arquillian.class)
public class TimeServiceIT {
    private static final Date FIXED_DATE = new Date(1321009871);

    @Inject
    private TimeService timeService;

    @Deployment
    public static JavaArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(LocaleManager.class, TimeService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testCreateTimestamp() {
        assertFalse("Sat, Feb 22, 2012".equals(timeService
                .getLocalizedTime(FIXED_DATE)));
        assertEquals("Fri, Jan 16, 1970",
                timeService.getLocalizedTime(FIXED_DATE));

    }
}
