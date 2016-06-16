package houseware.learn.testing.jpa;

import org.junit.Test;

import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fphilip@houseware.es
 */
public class FromFilePersistenceTest {

    @Test
    public void model_is_ok() {
        schema("persistence-unit");
    }

    private void schema(String pu) {

        Map<String, Object> p = new HashMap<>();

        p.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        p.put("javax.persistence.jdbc.url","jdbc:hsqldb:mem:persistence-unit");
        p.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        p.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
        p.put("javax.persistence.schema-generation.scripts.drop-target", "./target/" + pu+ ".ddl");
        p.put("javax.persistence.schema-generation.scripts.create-target", "./target/" + pu+ ".ddl");

        Persistence.generateSchema(pu, p);

    }
}

