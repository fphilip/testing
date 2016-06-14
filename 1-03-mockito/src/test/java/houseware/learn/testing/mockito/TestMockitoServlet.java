package houseware.learn.testing.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestMockitoServlet {

    @Mock
    HttpServletRequest httpServletRequest;
    @Mock
    HttpServletResponse httpServletResponse;
    @Mock
    HttpSession httpSession;

    @Mock
    RequestDispatcher  requestDispatcher;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void login_servlet_ok() throws Exception {


        when(httpServletRequest.getParameter("user")).thenReturn("ragner");
        when(httpServletRequest.getParameter("password")).thenReturn("l0dbr0k");
        when(httpServletRequest.getParameter("rememberMe")).thenReturn("Y");
        when(httpServletRequest.getSession()).thenReturn(httpSession);
        when(httpServletRequest.getRequestDispatcher("/welcome.do")).thenReturn(requestDispatcher);


        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(httpServletResponse.getWriter()).thenReturn(printWriter);

        new LoginServlet().doPost(httpServletRequest, httpServletResponse);

        verify(httpSession).setAttribute("user", "ragner");
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);
        String result = stringWriter.getBuffer().toString().trim();
        Assert.assertEquals("Login successfull...", result);
    }
}
