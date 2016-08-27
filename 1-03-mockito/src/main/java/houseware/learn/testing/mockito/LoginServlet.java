package houseware.learn.testing.mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("user");
        String pwd = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");

        if (name.equals("ragner") && pwd.equals("l0dbr0k")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", name);
            Cookie ck1 = new Cookie("user", name);
            Cookie ck2 = new Cookie("pwd", pwd);
            res.addCookie(ck1);
            res.addCookie(ck2);
            if (rememberMe != null && rememberMe.trim().length() > 0) {
                Cookie ck3 = new Cookie("rememberMe", rememberMe);
                res.addCookie(ck3);
            }
        }

        PrintWriter out = res.getWriter();
        out.write("Login successfull...");
        RequestDispatcher rd = req.getRequestDispatcher("/welcome.do");
        rd.forward(req, res);
    }
}