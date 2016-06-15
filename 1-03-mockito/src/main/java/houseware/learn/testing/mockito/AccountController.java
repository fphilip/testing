package houseware.learn.testing.mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fphilip@houseware.es
 */

public class AccountController {
    HttpServletRequest httpServletRequest;
    HttpServletResponse httpServletResponse;
    AccountManager repository;

    public AccountController(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccountManager repository) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.repository = repository;
    }

    public void find() {
        repository.findAccountByName(httpServletRequest.getParameter("firstName"), httpServletRequest.getParameter("lastName"));
    }
}
