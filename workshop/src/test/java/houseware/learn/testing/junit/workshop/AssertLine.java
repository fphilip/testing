package houseware.learn.testing.junit.workshop;

import org.junit.Assert;

import java.io.*;

/**
* @author fphilip@houseware.es
*/
public class AssertLine {


   public static void assertLineFileEquals(InputStream inputStream, int lineNumber, String expectedLine) throws Exception {
       assertLineFileEquals(new BufferedReader(new InputStreamReader(inputStream)), lineNumber, expectedLine);
   }

   public static void assertLineFileEquals(File file, int lineNumber, String expectedLine) throws Exception {
       BufferedReader reader = new BufferedReader(new FileReader(file));
       assertLineFileEquals(reader, lineNumber, expectedLine);
   }

   public static void assertLineFileEquals(BufferedReader reader, int lineNumber, String expectedLine) throws Exception {
       try {
           int lineNum = 1;
           String line = reader.readLine();
           while (line != null && lineNum < lineNumber) {
               lineNum++;
               line = reader.readLine();
           }
           Assert.assertEquals("Line number " + lineNum + " does not match.", lineNumber, lineNum);
           Assert.assertEquals("Content line at number " + lineNum + " does not match.", expectedLine, line);
       } finally {
           reader.close();
       }
   }

}

