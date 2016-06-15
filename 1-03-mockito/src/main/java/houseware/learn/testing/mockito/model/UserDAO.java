package houseware.learn.testing.mockito.model;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class UserDAO {

    private EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User findById(Long l) {
       return  entityManager.find(User.class, l);
    }

    public List<User> list() {
        return entityManager.createNamedQuery("userByName", User.class).getResultList();
    }
}
