package houseware.learn.testing.mockito;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author fphilip@houseware.es
 */
public class TestMockitoController {


    @Test
    public void account_controller_manager_integration() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);


        AccountManager repository = mock(AccountManager.class);
        AccountController accountController = new AccountController(req, resp, repository);

        when(req.getParameter("firstName")).thenReturn("ragnar");
        when(req.getParameter("lastName")).thenReturn("lodbrok");

        accountController.find();

        ArgumentCaptor<String> firstNameCapture = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> laststNameCapture = ArgumentCaptor.forClass(String.class);
        verify(repository).findAccountByName(firstNameCapture.capture(), laststNameCapture.capture());

        assertEquals(firstNameCapture.getValue(), "ragnar");
        assertEquals(laststNameCapture.getValue(), "lodbrok");

    }


}
