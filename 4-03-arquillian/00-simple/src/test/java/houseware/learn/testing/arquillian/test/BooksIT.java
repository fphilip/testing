package houseware.learn.testing.arquillian.test;

import houseware.learn.testing.arquillian.books.Book;
import houseware.learn.testing.arquillian.books.BookEJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class BooksIT {
    @Inject
    private BookEJB bookEJB;

    @TargetsContainer(value = "wildfly-embedded")
    @Deployment
    public static WebArchive createArchiveAndDeploy() {
        WebArchive s = ShrinkWrap.create(WebArchive.class)
                .addPackage("houseware.learn.testing.arquillian.books")
                .addAsResource("persistence-test-wildfly.xml", "WEB-INF/classes/META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsDirectory("webapp");


        System.out.println(s.toString(true));
        return s;
    }

    @Test
    public void test_home_ok(){

    }
}
