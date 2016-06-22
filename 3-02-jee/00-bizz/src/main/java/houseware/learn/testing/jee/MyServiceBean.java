package houseware.learn.testing.jee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
@Stateless
public class MyServiceBean {

    @PersistenceContext(unitName = "my-unit", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public void tic() {
        System.err.println("TIC");
    }


    public void addEntity(MyEntity entity) {
        entityManager.persist(entity);
    }

    public void deleteEntity(MyEntity entity) {
        entityManager.remove(entity);
    }

    public List<MyEntity> getEntities() throws Exception {
        Query query = entityManager.createQuery("SELECT m from MyEntity as m");
        return query.getResultList();
    }
}
