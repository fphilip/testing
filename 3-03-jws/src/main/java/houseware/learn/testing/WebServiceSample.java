package houseware.learn.testing;

import javax.jws.WebService;

@WebService
public interface WebServiceSample {
    String sayHello(String name);
}