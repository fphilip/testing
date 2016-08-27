package houseware.learn.testing.jws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "urn:test")
public interface WebServiceSample {
    @WebMethod(action = "say")
    String say(String name);
}