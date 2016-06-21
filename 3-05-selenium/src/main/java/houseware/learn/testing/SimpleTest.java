package houseware.learn.testing;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author fphilip@houseware.es
 */
public class SimpleTest extends AbstractEmbeddedTomcatTest {

    @BeforeClass
    public static void init() throws IOException {
        setApplicationId("showcase-5.3");

        File war = new File(getmWorkingDir(), "showcase-5.3.war");
        System.out.println("File:"+war.getAbsolutePath());
        FileUtils.copyInputStreamToFile(
                new URL("http://repository.primefaces.org/org/primefaces/showcase/5.3/showcase-5.3.war").openConnection().getInputStream(),
                war

        );


    }

    @Test
    public void heyho(){

    }




}
