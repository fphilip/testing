package houseware.learn.testing.openejb.test;

import houseware.learn.testing.jee.MyEntity;
import houseware.learn.testing.jee.MyService;
import houseware.learn.testing.jee.MyServiceBean;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.StatefulBean;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.junit.Configuration;
import org.apache.openejb.junit.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

@RunWith(ApplicationComposer.class)
public class OpenEJBComposerTest {

    @EJB
    private MyService service;

    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext
    private EntityManager entityManager;

    @Module
    public PersistenceUnit persistence() {
        PersistenceUnit unit = new PersistenceUnit("my-unit");
        unit.setJtaDataSource("myDb");
        unit.setNonJtaDataSource("myDbUnmanaged");
        unit.getClazz().add(MyEntity.class.getName());
        unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
        return unit;
    }

    @Module
    public EjbJar beans() {
        EjbJar ejbJar = new EjbJar("myentity-beans");
        ejbJar.addEnterpriseBean(new StatefulBean(MyServiceBean.class));
        return ejbJar;
    }

    @Configuration
    public Properties config() throws Exception {
        Properties p = new Properties();
        p.put("myDb", "new://Resource?type=DataSource");
        p.put("myDb.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("myDb.JdbcUrl", "jdbc:hsqldb:mem:entitydb");
        return p;
    }

    @Test
    public void delete() throws Exception {

        userTransaction.begin();

        try {
            entityManager.persist(new MyEntity("AAA", "A A A"));

            List<MyEntity> list = service.getEntities();
            assertEquals("Qty", 3, list.size());

            for (MyEntity e : list) {
                service.deleteEntity(e);
            }

            assertEquals("Entities", 0, service.getEntities().size());

        } finally {
            userTransaction.commit();
        }
    }
}