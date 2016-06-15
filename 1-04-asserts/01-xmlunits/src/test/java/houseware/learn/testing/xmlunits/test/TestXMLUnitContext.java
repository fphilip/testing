package houseware.learn.testing.xmlunits.test;


import houseware.learn.testing.xmlunits.AssertXML;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.InputStream;
import static org.junit.Assert.*;

/**
 * @author fphilip@houseware.es
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class TestXMLUnitContext {



    @Test
    public void context_are_equals(){
        InputStream is1 = TestXMLUnitContext.class.getClassLoader().getResourceAsStream("xmls/context1.xml");

        InputStream is2 =TestXMLUnitContext.class.getClassLoader().getResourceAsStream("xmls/context2.xml");
        assertNotNull(is1);
        assertNotNull(is2);


        AssertXML.assertXMLEquals(is1, is2,true);
    }

    @Test
    public void context_are_not_equals(){
        InputStream is1 = TestXMLUnitContext.class.getClassLoader().getResourceAsStream("xmls/context1.xml");

        InputStream is2 =TestXMLUnitContext.class.getClassLoader().getResourceAsStream("xmls/context3.xml");
        assertNotNull(is1);
        assertNotNull(is2);


        AssertXML.assertXMLEquals(is1, is2,false);
    }


}
