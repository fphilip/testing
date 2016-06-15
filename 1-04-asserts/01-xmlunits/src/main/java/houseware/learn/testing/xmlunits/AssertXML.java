package houseware.learn.testing.xmlunits;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
@SuppressWarnings("unused")
public class AssertXML {


    public static void assertXMLEquals(String expectedXML, String actualXML) {
        assertXMLEquals(expectedXML, actualXML, false);
    }

    public static void assertXMLEquals(String expectedXML, String actualXML, boolean identical) {
        try {
            assertDiff(XMLUnit.compareXML(expectedXML, actualXML), identical);
        } catch (SAXException e) {
            throw new AssertionError(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertXMLEquals(InputStream expectedXML, InputStream actualXML) {
        assertXMLEquals(expectedXML, actualXML, false);

    }

    public static void assertXMLEquals(InputStream expectedXML, InputStream actualXML, boolean identical) {
        try {
            assertDiff(XMLUnit.compareXML(new InputStreamReader(expectedXML), new InputStreamReader(actualXML)), identical);
        } catch (SAXException e) {
            throw new AssertionError(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void assertDiff(Diff diff, boolean identical) {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);

        DetailedDiff detailedDiff = new DetailedDiff(diff);

        List allDifferences = detailedDiff.getAllDifferences();

        if ((identical && !detailedDiff.identical()) || (!identical && (!detailedDiff.identical() && !detailedDiff.similar())))
            Assert.assertEquals("Differences found: " + detailedDiff.toString(), 0, allDifferences.size());
    }

}
