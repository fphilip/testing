package houseware.learn.testing.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyManager {

    public static Server startServer() throws Exception {
        Server server = new Server(7070);
        ServletContextHandler context = new ServletContextHandler();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/sample");
        webAppContext.setBaseResource(
                new ResourceCollection(
                        new String[] {"./javaee6-sample-master/src/main/webapp", "./javaee6-sample-master/src/main/resources", "./javaee6-sample-master/src/main/setup"}));

        webAppContext.setResourceAlias("/WEB-INF/classes/", "/classes/");
        server.setHandler(webAppContext);
        server.setStopAtShutdown(true);
        server.start();
        server.join();
        return server;
    }

    public static void stopServer(Server server) throws Exception {
        server.stop();
    }

}
