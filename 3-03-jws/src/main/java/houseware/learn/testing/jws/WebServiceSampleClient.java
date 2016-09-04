package houseware.learn.testing.jws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author fphilip@houseware.es
 */
public class WebServiceSampleClient {

    public static WebServiceSample client(String url) throws MalformedURLException {
        QName serviceQN = new QName("urn:test", "MyWsService");
        Service service = Service.create(new URL(url), serviceQN);

        QName portQN = new QName( "urn:test", "MyPort");

        return  service.getPort(portQN, WebServiceSample.class);
    }
}
