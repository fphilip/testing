package houseware.learn.testing.mockito.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author fphilip@houseware.es
 */
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoUserServices1 {

    @Mock
    UserDAO userDAO;

    @Before
    public void setUp() {
        when(userDAO.findById( 1L)).thenReturn(new User(1L, "juanito", "lopez"));
        when(userDAO.findById( 18L)).thenReturn(new User(18L, "alvarito", "perez"));
        when(userDAO.findById( 0L)).thenReturn(null);

        when(userDAO.findById( -10L)).thenReturn(null);
        when(userDAO.findById( null)).thenReturn(null);
    }

    @Test
    public void validar_findAndUpper_with_1() {
        User u = new UserServices(userDAO).findAndUpper(1L);
        assertNotNull("user is null",u);
        assertEquals("juanito", u.getFirstName());
    }

    @Test
    public void validar_findAndUpper_with_18() {
        User u = new UserServices(userDAO).findAndUpper(18L);
        assertNotNull("user is null",u);
        assertEquals("ALVARITO", u.getFirstName());
    }

    @Test
    public void validar_findAndUpper_with_null() {
        User u = new UserServices(userDAO).findAndUpper(null);
        assertNull(u);
    }


}
