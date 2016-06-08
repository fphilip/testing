package houseware.learn.testing.jee;

import com.sun.net.httpserver.HttpServer;
 
import java.net.URI;
 
import javax.ws.rs.core.UriBuilder;
 
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
 
public class CinemaEventHandlerRestStartup {
 
private final static int port = 9123;
private final static String host="http://localhost/”;
 
public static void main(String[] args) {
URI baseUri = UriBuilder.fromUri(host).port(port).build();
ResourceConfig config = new ResourceConfig(CinemaEventHandler.class);
HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
}