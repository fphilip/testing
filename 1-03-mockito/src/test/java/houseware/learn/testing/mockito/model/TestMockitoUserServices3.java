package houseware.learn.testing.mockito.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author fphilip@houseware.es
 */
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoUserServices3 {

    @Mock
    EntityManager entityManager;

    @Before
    public void setUp() {

        TypedQuery<User> mockedQuery = mock(TypedQuery.class);
        when(mockedQuery.getResultList()).thenReturn(Arrays.asList(
                new User(1L, "juanito", "lopez"),
                new User(18L, "alvarito", "perez"),
                new User(19L, "marito", "rodriguez")
        ));
        when(entityManager.createNamedQuery("userByName", User.class)).thenReturn(mockedQuery);

    }


    @Test
    public void validar_query_list() {
        List<User> users = new UserServices(new UserDAO(entityManager)).list();
        for (User user : users) {
            System.err.println(user.getFirstName()+" "+user.getLastName());
        }
        assertEquals("juanito", users.get(0).getFirstName());
        assertEquals("alvarito", users.get(1).getFirstName());
        assertEquals("marito", users.get(2).getFirstName());


    }

}
