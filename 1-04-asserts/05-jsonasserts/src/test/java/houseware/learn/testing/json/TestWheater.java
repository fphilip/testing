package houseware.learn.testing.json;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonPartEquals;
import static net.javacrumbs.jsonunit.JsonMatchers.jsonNodePresent;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertNotNull;

/**
 * @author fphilip@houseware.es
 */
public class TestWheater {


    @Test
    public void is_ok_wheater() throws IOException {

        URL api = new URL("http://api.openweathermap.org/data/2.5/weather?q=Barcelona&APPID=89b33383e58ddacaad44521d59b3e3df");


        URLConnection conn = api.openConnection();
        InputStream inputStream = conn.getInputStream();
        assertNotNull("Connection not Ok", inputStream);
        String co = IOUtils.toString(inputStream);
        assertNotNull("Content not Ok", co);

        assertJsonPartEquals("Barcelona", co,
                "name");
        assertJsonPartEquals("ES", co,
                "sys.country");

        assertThatJson(co)
                .node("main")
                .matches(jsonNodePresent("pressure"));
        assertThatJson(co)
                .node("main")
                .matches(jsonNodePresent("temp"));
        assertThatJson(co)
                .node("main")
                .matches(jsonNodePresent("humidity"));


//                      .matches(everyItem(anyOf(is("pressure"),is("temp"),is("humidity"),is("temp_min"),is("temp_max"))));

    }

}
