package houseware.learn.testing;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author fphilip@houseware.es
 */
public class WebServiceSampleClient {

    public String say(String say) throws MalformedURLException {
        String url = "http://localhost:9191/webServiceTest?wsdl";
        String namespace = "http://another/";
        QName serviceQN = new QName(namespace, "WebServiceTestService");
        Service service = Service.create(new URL(url), serviceQN);

        String portName = "WebServicePort";
        QName portQN = new QName(namespace, portName);

        WebServiceSample sample = service.getPort(portQN, WebServiceSample.class);
        return sample.sayHello("Me");
    }
}
