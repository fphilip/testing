package houseware.learn.testing.arquillian.persistence.test;

import houseware.learn.testing.arquillian.persistence.Club;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@RunWith(Arquillian.class)
public class TestArquillianJarArchive {

    @Deployment
    public static JavaArchive createTestArchive() {

        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackage(Club.class.getPackage().getName())
                .addAsManifestResource("jar-persistence.xml", "persistence.xml")
                .addAsResource("import.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "WEB-INF/beans.xml");
        log.info(archive.toString(true));
        return archive;
    }


    @Getter
    @PersistenceContext
    protected EntityManager entityManager;

    @Test
    public void list_all_clubs_order_by_league() {
        for (Club club : entityManager.createQuery("select object(c) from Club c order by c.league", Club.class).getResultList()) {
            log.info(club.getName());
        }

    }
}
