package houseware.learn.testing.mockito.model;

import houseware.learn.testing.mockito.model.User;
import houseware.learn.testing.mockito.model.UserDAO;
import houseware.learn.testing.mockito.model.UserServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * @author fphilip@houseware.es
 */
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoUserServices2 {

    @Mock
    EntityManager entityManager;

    @Before
    public void setUp() {
        when(entityManager.find(User.class, 1L)).thenReturn(new User(1L, "juanito", "lopez"));
        when(entityManager.find(User.class, 18L)).thenReturn(new User(18L, "alvarito", "perez"));
        when(entityManager.find(User.class, 0L)).thenReturn(null);

        when(entityManager.find(User.class, -10L)).thenReturn(null);
        when(entityManager.find(User.class, null)).thenReturn(null);
    }

    @Test
    public void validar_findAndUpper_with_1() {
        User u = new UserServices(new UserDAO(entityManager)).findAndUpper(1L);
        assertNotNull("user is null",u);
        assertEquals("juanito", u.getFirstName());
        assertEquals("LOPEZ", u.getLastName());
    }

    @Test
    public void validar_findAndUpper_with_18() {
        User u = new UserServices(new UserDAO(entityManager)).findAndUpper(18L);
        assertNotNull("user is null",u);
        assertEquals("ALVARITO", u.getFirstName());
    }

    @Test
    public void validar_findAndUpper_with_null() {
        User u = new UserServices(new UserDAO(entityManager)).findAndUpper(null);
        assertNull(u);
    }


}
