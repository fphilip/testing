package houseware.learn.testing.jws;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;

/**
 * @author fphilip@houseware.es
 */
public class WebServiceSampleTest {
    Endpoint endpoint ;


   @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("javax.xml.ws.spi.Provider", "com.sun.xml.internal.ws.spi.ProviderImpl");

        WebServiceSampleImp e = new WebServiceSampleImp();
         endpoint = Endpoint.publish("http://127.0.0.1:9190/8", e);
//        Endpoint endpoint = new ProviderImpl().createAndPublishEndpoint("http://127.0.0.1:9876/8", e);
//        endpoint.stop();


    }
    @After
    public void tearDown(){
        endpoint.stop();
    }

    @Test
    public void test8() throws MalformedURLException {
        WebServiceSample wsl = WebServiceSampleClient.client("http://127.0.0.1:9190/8?wsdl");
        String s = wsl.say("Me");
        System.err.println("Say:"+s);
        Assert.assertEquals("Hi Me",s);
    }

}
