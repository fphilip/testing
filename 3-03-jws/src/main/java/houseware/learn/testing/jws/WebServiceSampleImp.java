package houseware.learn.testing.jws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author fphilip@houseware.es
 */
@WebService(serviceName = "MyWsService",portName = "MyPort", targetNamespace = "urn:test")
public class WebServiceSampleImp implements WebServiceSample {

    @WebMethod(action = "say")
    @Override
    public String say(String name) {
        return "Hi "+name;

    }
}
